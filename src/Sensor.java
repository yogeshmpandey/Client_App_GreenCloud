/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BlackPearl
 */
public class Sensor {
    
    private String CurrentDate;
    private String SunshineHr;

    
    private String WaterConsumed;
    private String MaxHumidity;
    private String MinHumidity;
    private String MaxTemprature;
    private String Mintemprature;
    private String AvgWindSpeed;
    private String SoilMoisture;
    private String FertilizersUsed;
    private String RainFall;
    private String username;
    private String FertilizerQuantity;

    public String getFertilizerQuantity() {
        return FertilizerQuantity;
    }

    public void setFertilizerQuantity(String FertilizerQuantity) {
        this.FertilizerQuantity = FertilizerQuantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getCurrentDate() {
        return CurrentDate;
    }
    public void setCurrentDate(String CurrentDate) {
        this.CurrentDate = CurrentDate;
    }
    
    public String getWaterConsumed() {
        return WaterConsumed;
    }

    public void setWaterConsumed(String WaterConsumed) {
        this.WaterConsumed = WaterConsumed;
    }

    public String getMaxHumidity() {
        return MaxHumidity;
    }

    public void setMaxHumidity(String MaxHumidity) {
        this.MaxHumidity = MaxHumidity;
    }

    public String getMinHumidity() {
        return MinHumidity;
    }

    public void setMinHumidity(String MinHumidity) {
        this.MinHumidity = MinHumidity;
    }

   

    public String getMaxTemprature() {
        return MaxTemprature;
    }

    public void setMaxTemprature(String MaxTemprature) {
        this.MaxTemprature = MaxTemprature;
    }

    public String getMintemprature() {
        return Mintemprature;
    }

    public void setMintemprature(String Mintemprature) {
        this.Mintemprature = Mintemprature;
    }
public String getAvgWindSpeed() {
        return AvgWindSpeed;
    }

    public void setAvgWindSpeed(String AvgWindSpeed) {
        this.AvgWindSpeed = AvgWindSpeed;
    }

    public String getSoilMoisture() {
        return SoilMoisture;
    }

    public void setSoilMoisture(String SoilMoisture) {
        this.SoilMoisture = SoilMoisture;
    }

    public String getFertilizersUsed() {
        return FertilizersUsed;
    }

    public void setFertilizersUsed(String FertilizersUsed) {
        this.FertilizersUsed = FertilizersUsed;
    }

    public String getRainFall() {
        return RainFall;
    }

    public void setRainFall(String RainFall) {
        this.RainFall = RainFall;
    }
    
    public String getSunshineHr() {
        return SunshineHr;
    }

    public void setSunshineHr(String SunshineHr) {
        this.SunshineHr = SunshineHr;
    }

    
}
