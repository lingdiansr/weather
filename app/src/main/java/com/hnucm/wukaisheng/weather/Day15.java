package com.hnucm.wukaisheng.weather;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Day15 {

    @SerializedName("showapi_res_error")
    private String showapiResError;
    @SerializedName("showapi_res_id")
    private String showapiResId;
    @SerializedName("showapi_res_code")
    private Integer showapiResCode;
    @SerializedName("showapi_fee_num")
    private Integer showapiFeeNum;
    @SerializedName("showapi_res_body")
    private ShowapiResBodyDTO showapiResBody;

    public String getShowapiResError() {
        return showapiResError;
    }

    public void setShowapiResError(String showapiResError) {
        this.showapiResError = showapiResError;
    }

    public String getShowapiResId() {
        return showapiResId;
    }

    public void setShowapiResId(String showapiResId) {
        this.showapiResId = showapiResId;
    }

    public Integer getShowapiResCode() {
        return showapiResCode;
    }

    public void setShowapiResCode(Integer showapiResCode) {
        this.showapiResCode = showapiResCode;
    }

    public Integer getShowapiFeeNum() {
        return showapiFeeNum;
    }

    public void setShowapiFeeNum(Integer showapiFeeNum) {
        this.showapiFeeNum = showapiFeeNum;
    }

    public ShowapiResBodyDTO getShowapiResBody() {
        return showapiResBody;
    }

    public void setShowapiResBody(ShowapiResBodyDTO showapiResBody) {
        this.showapiResBody = showapiResBody;
    }

    public static class ShowapiResBodyDTO {
        @SerializedName("dayList")
        private List<DayListDTO> dayList;
        @SerializedName("remark")
        private String remark;
        @SerializedName("areaid")
        private String areaid;
        @SerializedName("ret_code")
        private Integer retCode;
        @SerializedName("area")
        private String area;
        @SerializedName("areaCode")
        private String areaCode;

        public List<DayListDTO> getDayList() {
            return dayList;
        }

        public void setDayList(List<DayListDTO> dayList) {
            this.dayList = dayList;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getAreaid() {
            return areaid;
        }

        public void setAreaid(String areaid) {
            this.areaid = areaid;
        }

        public Integer getRetCode() {
            return retCode;
        }

        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public static class DayListDTO {
            @SerializedName("night_weather_pic")
            private String nightWeatherPic;
            @SerializedName("daytime")
            private String daytime;
            @SerializedName("day_wind_direction")
            private String dayWindDirection;
            @SerializedName("day_weather_code")
            private String dayWeatherCode;
            @SerializedName("area")
            private String area;
            @SerializedName("night_wind_power")
            private String nightWindPower;
            @SerializedName("night_weather_code")
            private String nightWeatherCode;
            @SerializedName("areaCode")
            private String areaCode;
            @SerializedName("day_weather")
            private String dayWeather;
            @SerializedName("day_air_temperature")
            private String dayAirTemperature;
            @SerializedName("night_wind_direction")
            private String nightWindDirection;
            @SerializedName("areaid")
            private String areaid;
            @SerializedName("night_weather")
            private String nightWeather;
            @SerializedName("night_air_temperature")
            private String nightAirTemperature;
            @SerializedName("day_weather_pic")
            private String dayWeatherPic;
            @SerializedName("day_wind_power")
            private String dayWindPower;

            private Calendar calendar = Calendar.getInstance();
            private int nowHour = calendar.get(Calendar.HOUR_OF_DAY);
            private boolean isDay = nowHour > 6 && nowHour < 18;

            public String getWeatherPic(){
                return isDay ? getDayWeatherPic() : getNightWeatherPic();
            }
            public String getWeather(){
                return isDay?getDayWeather():getNightWeather();
            }
            public String getWind(){
                return isDay ? getDayWindPower() + getDayWindDirection() : getNightWindPower() + getNightWindDirection();
            }
            public String getAirTemperature(){
                return getDayAirTemperature() + "° / " + getNightAirTemperature() + "°";
            }
            public String getDay(int position, Day15.ShowapiResBodyDTO.DayListDTO dayListDTO) {
                String day ;
                if (0== position){
                    day="今天";
                } else if (1== position) {
                    day="明天";
                }else {
                    SimpleDateFormat Formatter = new SimpleDateFormat("yyyyMMdd");
                    try {
                        String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
                        Date MMdd = Formatter.parse(dayListDTO.getDaytime());
                        Calendar weeksCal = Calendar.getInstance();
                        weeksCal.setTime(MMdd);
                        day=weekDays[weeksCal.get(Calendar.DAY_OF_WEEK)-1];
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
                return day;
            }
            public String getNightWeatherPic() {
                return nightWeatherPic;
            }

            public void setNightWeatherPic(String nightWeatherPic) {
                this.nightWeatherPic = nightWeatherPic;
            }

            public String getDaytime() {
                return daytime;
            }

            public void setDaytime(String daytime) {
                this.daytime = daytime;
            }

            public String getDayWindDirection() {
                return dayWindDirection;
            }

            public void setDayWindDirection(String dayWindDirection) {
                this.dayWindDirection = dayWindDirection;
            }

            public String getDayWeatherCode() {
                return dayWeatherCode;
            }

            public void setDayWeatherCode(String dayWeatherCode) {
                this.dayWeatherCode = dayWeatherCode;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getNightWindPower() {
                return nightWindPower;
            }

            public void setNightWindPower(String nightWindPower) {
                this.nightWindPower = nightWindPower;
            }

            public String getNightWeatherCode() {
                return nightWeatherCode;
            }

            public void setNightWeatherCode(String nightWeatherCode) {
                this.nightWeatherCode = nightWeatherCode;
            }

            public String getAreaCode() {
                return areaCode;
            }

            public void setAreaCode(String areaCode) {
                this.areaCode = areaCode;
            }

            public String getDayWeather() {
                return dayWeather;
            }

            public void setDayWeather(String dayWeather) {
                this.dayWeather = dayWeather;
            }

            public String getDayAirTemperature() {
                return dayAirTemperature;
            }

            public void setDayAirTemperature(String dayAirTemperature) {
                this.dayAirTemperature = dayAirTemperature;
            }

            public String getNightWindDirection() {
                return nightWindDirection;
            }

            public void setNightWindDirection(String nightWindDirection) {
                this.nightWindDirection = nightWindDirection;
            }

            public String getAreaid() {
                return areaid;
            }

            public void setAreaid(String areaid) {
                this.areaid = areaid;
            }

            public String getNightWeather() {
                return nightWeather;
            }

            public void setNightWeather(String nightWeather) {
                this.nightWeather = nightWeather;
            }

            public String getNightAirTemperature() {
                return nightAirTemperature;
            }

            public void setNightAirTemperature(String nightAirTemperature) {
                this.nightAirTemperature = nightAirTemperature;
            }

            public String getDayWeatherPic() {
                return dayWeatherPic;
            }

            public void setDayWeatherPic(String dayWeatherPic) {
                this.dayWeatherPic = dayWeatherPic;
            }

            public String getDayWindPower() {
                return dayWindPower;
            }

            public void setDayWindPower(String dayWindPower) {
                this.dayWindPower = dayWindPower;
            }
        }
    }
}
