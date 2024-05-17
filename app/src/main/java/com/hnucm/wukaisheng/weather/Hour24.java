package com.hnucm.wukaisheng.weather;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Hour24 {

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
        @SerializedName("remark")
        private String remark;
        @SerializedName("hourList")
        private List<HourListDTO> hourList;
        @SerializedName("ret_code")
        private Integer retCode;
        @SerializedName("areaid")
        private String areaid;
        @SerializedName("area")
        private String area;
        @SerializedName("areaCode")
        private String areaCode;


        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public List<HourListDTO> getHourList() {
            return hourList;
        }

        public void setHourList(List<HourListDTO> hourList) {
            this.hourList = hourList;
        }

        public Integer getRetCode() {
            return retCode;
        }

        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        public String getAreaid() {
            return areaid;
        }

        public void setAreaid(String areaid) {
            this.areaid = areaid;
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

        public static class HourListDTO {
            @SerializedName("time")
            private String time;
            @SerializedName("wind_direction")
            private String windDirection;
            @SerializedName("wind_power")
            private String windPower;
            @SerializedName("areaid")
            private String areaid;
            @SerializedName("weather_code")
            private String weatherCode;
            @SerializedName("temperature")
            private String temperature;
            @SerializedName("area")
            private String area;
            @SerializedName("weather")
            private String weather;

            public String getFormattedTime(){
                Calendar calendar = Calendar.getInstance();
                String time = getTime();
                int hour = Integer.parseInt(time.substring(8,10)); // 获取小时的整数形式
                int currentHour = calendar.get(Calendar.HOUR_OF_DAY); // 获取当前小时

                return (hour == currentHour) ? "现在" : time.substring(8,10)+":"+time.substring(10);
            }
            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getWindDirection() {
                return windDirection;
            }

            public void setWindDirection(String windDirection) {
                this.windDirection = windDirection;
            }

            public String getWindPower() {
                return windPower;
            }

            public void setWindPower(String windPower) {
                this.windPower = windPower;
            }

            public String getAreaid() {
                return areaid;
            }

            public void setAreaid(String areaid) {
                this.areaid = areaid;
            }

            public String getWeatherCode() {
                return weatherCode;
            }

            public void setWeatherCode(String weatherCode) {
                this.weatherCode = weatherCode;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }
        }
    }
}
