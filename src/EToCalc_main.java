/*
 * 
 */


import java.lang.Math;
/**
 *
 * http://www.fao.org/docrep/X0490E/X0490E00.htm,paper "National Weather Service Reference Evapotranspiration Forecast(R.L. Snyder1, C. Palmer2, M. Orang3, M. Anderson4)"
 *  referred for this code
 * @bharat 
 */

public class EToCalc_main {
    //constants
    private final  float pi=3.14159265358979323846f;
    //Steffan-Boltzman constant for MJ m-2 d-1 K-4
    private final  float sigma=(float)(4.903*(Math.pow(10,(-9))));
    //degree celsius all
    private float TMax ;
    private float TMin ;
    private float Tmean ;
    //altitude of place, m
    private float altitude ;
    //wind speed u2, m/s
    private float u2 ;
    //Relative humidity %
    private  float RHMax;
    private  float RHMin;
    //latitude in degrees,day of month, year in AD. 
    private float latitude;
    private  int Day=6;
    private  int Month=7;
    //actual sunshine hours
    private  float nhr=6;
    //cloud cover in percentage
    private  float Cc;
    private  int Year=2011;
    //tmonth= upper soil temp, tmonth_1=lower soil temperature in celsius
    private  float tmonth;
    private  float tmonth_1;
   
    
    
    //Es
    //refer annex 2 table 2.3
    public  float SVP(float T)
    {
        float SVP;
        float temp_exp1 = (float) (T+237.3);
        SVP = (float) ((17.27*T)/temp_exp1);
        SVP=(float)( Math.exp(SVP));
        SVP=(float)(SVP* 0.6108);
        return SVP;
    }
    
    //Ea
    //SVP at dew point refer paper "National Weather Service Reference Evapotranspiration Forecast(R.L. Snyder1, C. Palmer2, M. Orang3, M. Anderson4)"
    public  float SVPd(float RHMax, float RHMin, float TMax, float TMin)
    {
        float SVPd;
 //     Todo:check what's better formula
 //     Alternate formula
 //     SVPd=(50/(SVP(TMax)))+(50/(SVP(TMin)));
 //     SVPd=((RHMax+RHMin)/2)/SVPd ;
        SVPd=RHMax*SVP(TMin)+RHMin*SVP(TMax);
        SVPd=SVPd/200;
        return SVPd;
    }
        
    //refer annex 2 table 2.4
      
    public  float delta(float T)
    {
        //T in celsius
        // delta in (KPa/Degree celsius)
        float delta;
        float temp_exp1 = (float) (T+237.3);
        delta=SVP(T);
        delta=4098*delta;
        delta=(float) (delta/(Math.pow(temp_exp1,2)));
        return delta;
    }
    //refer annex 2 table 2.1
    
    public  float Atm_pressure(float altitude)
    {
        float pressure;
        pressure=(float)(293-.0065*altitude);
        pressure=pressure/293;
        pressure=(float)(Math.pow(pressure,5.26));
        pressure=(float)(pressure*101.3);
        return pressure;
    }
    
    
    
    //refer annex 2 table 2.2
    public  float gamma(float altitude)
    {
        float gamma;
        float const_attrib=(float)(0.000665);
        gamma=const_attrib*Atm_pressure(altitude);
        return gamma;
    }
    
    //refer annex 2 table 2.6 and paper "National Weather Service Reference Evapotranspiration Forecast(R.L. Snyder1, C. Palmer2, M. Orang3, M. Anderson4)"
    public  float Ra(float latitude, int day, int month, int year)
    {
        float Ra;
        //solar constant in MJ m-2 min-1
        float Gsc=(float)(0.082);
        //latitude in radians
        float phi=(float)((latitude/180)*pi);
        //Eccentricity correction Dr
        float Dr=(float)(Math.cos(((2*pi)/365)*i(day,month,year)));
        Dr=(float) (1+(.033*Dr));
        //declination of the sun above the celestial equator in radians on day i of the year
        float del=(float)(Math.sin(((2*pi)/365)*i(day,month,year)-1.39));
        del=(float) (del*.409);
        //sunrise hour angle in radians
        float omegas= (float) (-(Math.tan(phi)*Math.tan(del)));
        omegas= (float) (Math.acos(omegas));
        Ra=(float) (24*60/pi);
        Ra=Ra*Gsc*Dr;
        Ra=(float) (Ra*((omegas*Math.sin(del)*Math.sin(phi))+(Math.cos(phi)*Math.cos(del)*Math.sin(omegas))));
        return Ra;
    }
    
    //net solar radiation
    //refer paper "National Weather Service Reference Evapotranspiration Forecast(R.L. Snyder1, C. Palmer2, M. Orang3, M. Anderson4)"
    public  float Rns(float latitude, float nhr,int day, int month, int year)
    {
        float Rns;
        float temp=nhr/N(latitude,day, month, year);
        float Rs=(float)(0.5*temp+0.25);
        Rs=Rs*Ra(latitude,day, month, year);
        Rns=(float) (0.77*Rs);
        return Rns;
    }
    //Rns, use any int value for using with Cloud cover
    public  float Rns(float latitude, float Cc,int switch_integer,int day, int month, int year)
    {
        float Rns;
        float temp=(float)(0.9659-.0083*Cc);
        float Rs=(float)(0.5*temp+0.25);
        Rs=Rs*Ra(latitude, day, month, year);
        Rns=(float) (0.77*Rs);
        return Rns;
    }
    
    //Clear sky total global solar radiation at earth's surface
    //refer paper "National Weather Service Reference Evapotranspiration Forecast(R.L. Snyder1, C. Palmer2, M. Orang3, M. Anderson4)"
    public  float Rso(float alt, float lat,int day, int month, int year)
    {
        float Rso;
        Rso=((2*alt)/100000);
        Rso=(float) (Rso+0.75);
        Rso=Ra(lat,day, month, year)*Rso;
        return Rso;
    }
    
    //net long wave radiation
    //refer paper "National Weather Service Reference Evapotranspiration Forecast(R.L. Snyder1, C. Palmer2, M. Orang3, M. Anderson4)"
    public  float Rnl(float Tmax_C,float Tmin_C, float RhMax, float RhMin, float lat, float Nhr, float alt,int day, int month, int year)
    {
        float Rnl;
        float temp_term;//temperature term
        float epsilon;
        float f;
        epsilon= (float) Math.sqrt(SVPd(RhMax,RhMin,Tmax_C,Tmin_C));
        epsilon= (float) (epsilon*(.14));
        epsilon= (float) (.34-epsilon);
        Tmax_C=(float) (Tmax_C+273.15);
        Tmin_C=(float) (Tmin_C+273.15);
        temp_term= (float)(Math.pow(Tmax_C, 4)+Math.pow(Tmin_C, 4));
        temp_term= (temp_term/2)*sigma;
        f=(float) (Rns(lat,Nhr,day, month,year)/.77);
        f=f/Rso(alt, lat,day, month, year);
        f=(float) ((f*1.35)-.35);
        Rnl=f*epsilon*temp_term;
        return Rnl;
    }
    
    // net radiation over grass
    //refer paper "National Weather Service Reference Evapotranspiration Forecast(R.L. Snyder1, C. Palmer2, M. Orang3, M. Anderson4)"
    public  float Rn(float Tmax_C,float Tmin_C, float RhMax, float RhMin, float lat, float Nhr, float alt, int day, int month, int year)
    {
        float Rn;
        Rn=Rns(lat,Nhr,day,month,year)-Rnl(Tmax_C,Tmin_C,RhMax,RhMin,lat,Nhr,alt,day, month, year);
        return Rn;    
    }
    //todo: Overloaded method of Rn
   
    
    
    //refer annex 2 table2.7, mean daylight hours
    public  float N(float latitude, int day, int month, int year)
    {
        float N;
        //solar constant in MJ m-2 min-1
        float Gsc=(float)(0.082);
        //latitude in radians
        float phi=(float)((latitude/180)*pi);
       //declination of the sun above the celestial equator in radians on day i of the year
        float del=(float)(Math.sin(((2*pi)/365)*i(day,month,year)-1.39));
        del=(float) (del*.409);
        //sunrise hour angle in radians
        float omegas= (float) (-(Math.tan(phi)*Math.tan(del)));
        omegas= (float) (Math.acos(omegas));
        N=24/pi;
        N=N*omegas;       
        return N;
    }
    
    
    // function for day of the year calculation
    public int i(int day, int month, int year)
    {
        int i;
        int leap_year=0;
        i=(int) Math.floor((275f*(month/9f) )- 30f + day);
        i=i-2;
        if((year%4)==0)
        {
           if((year%100)==0)
           {
               if((year%400)==0)
               {
                   leap_year=1;                        
               }
           }
           else
           {
               leap_year=1;
           }
        }
        if(month<3)
        {
            i=i+2;
        }
        if(((leap_year)==1)&&(month>2))
        {
            i=i+1;
        }
        return i;
    }
    
    //standard reference evapotranspiration
    //refer paper "National Weather Service Reference Evapotranspiration Forecast(R.L. Snyder1, C. Palmer2, M. Orang3, M. Anderson4)"
    //refer box 11, chapter 4 also
    public float ETo(float U2,float Tmonth, float Tmonth_1,float Tmax_C,float Tmin_C, float RhMax, float RhMin, float lat, float Nhr, float alt,int day, int month, int year )
    {
        float ETo;
        float Ro;
        float Ao;
        float G;
        float divisor;
        float es;
        G=(float) (0.14*(Tmonth-Tmonth_1));
        divisor=(float) (1+(.34*U2));
        divisor=divisor*gamma(alt);
        divisor=divisor+delta((Tmax_C+Tmin_C)/2);
        Ro=Rn(Tmax_C,Tmin_C,RhMax,RhMin,lat,Nhr,alt, day,  month,  year)-G;
        Ro=(float) (Ro*.408);
        Ro=Ro/divisor;
        Ro=Ro*delta((Tmax_C+Tmin_C)/2);
        Ao=900*gamma(alt);
        Ao=Ao/(((Tmax_C+Tmin_C)/2)+273);
        Ao=Ao/divisor;
        Ao=Ao*U2;
        es=(SVP(Tmax_C)+SVP(Tmin_C))/2;
        Ao=Ao*(es-SVPd(RhMax,RhMin,Tmax_C,Tmin_C));
        ETo=Ao+Ro;
        return ETo;
    }
  
}