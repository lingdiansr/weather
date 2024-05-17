package com.hnucm.wukaisheng.weather;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.HashMap;

public class SevenDaysInTheFuture {

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
        @SerializedName("cityInfo")
        private CityInfoDTO cityInfo;
        @SerializedName("date")
        private String date;
        @SerializedName("remark")
        private String remark;
        @SerializedName("f1")
        private F1DTO f1;
        @SerializedName("ret_code")
        private Integer retCode;

        public CityInfoDTO getCityInfo() {
            return cityInfo;
        }

        public void setCityInfo(CityInfoDTO cityInfo) {
            this.cityInfo = cityInfo;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public F1DTO getF1() {
            return f1;
        }

        public void setF1(F1DTO f1) {
            this.f1 = f1;
        }

        public Integer getRetCode() {
            return retCode;
        }

        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        public static class CityInfoDTO {
            @SerializedName("c4")
            private String c4;
            @SerializedName("c17")
            private String c17;
            @SerializedName("c5")
            private String c5;
            @SerializedName("c0")
            private String c0;
            @SerializedName("latitude")
            private Double latitude;
            @SerializedName("c7")
            private String c7;
            @SerializedName("c1")
            private String c1;
            @SerializedName("c15")
            private String c15;
            @SerializedName("c8")
            private String c8;
            @SerializedName("c2")
            private String c2;
            @SerializedName("c12")
            private String c12;
            @SerializedName("c11")
            private String c11;
            @SerializedName("c9")
            private String c9;
            @SerializedName("c6")
            private String c6;
            @SerializedName("c3")
            private String c3;
            @SerializedName("longitude")
            private Double longitude;
            @SerializedName("c16")
            private String c16;
            @SerializedName("c10")
            private String c10;

            public String getC4() {
                return c4;
            }

            public void setC4(String c4) {
                this.c4 = c4;
            }

            public String getC17() {
                return c17;
            }

            public void setC17(String c17) {
                this.c17 = c17;
            }

            public String getC5() {
                return c5;
            }

            public void setC5(String c5) {
                this.c5 = c5;
            }

            public String getC0() {
                return c0;
            }

            public void setC0(String c0) {
                this.c0 = c0;
            }

            public Double getLatitude() {
                return latitude;
            }

            public void setLatitude(Double latitude) {
                this.latitude = latitude;
            }

            public String getC7() {
                return c7;
            }

            public void setC7(String c7) {
                this.c7 = c7;
            }

            public String getC1() {
                return c1;
            }

            public void setC1(String c1) {
                this.c1 = c1;
            }

            public String getC15() {
                return c15;
            }

            public void setC15(String c15) {
                this.c15 = c15;
            }

            public String getC8() {
                return c8;
            }

            public void setC8(String c8) {
                this.c8 = c8;
            }

            public String getC2() {
                return c2;
            }

            public void setC2(String c2) {
                this.c2 = c2;
            }

            public String getC12() {
                return c12;
            }

            public void setC12(String c12) {
                this.c12 = c12;
            }

            public String getC11() {
                return c11;
            }

            public void setC11(String c11) {
                this.c11 = c11;
            }

            public String getC9() {
                return c9;
            }

            public void setC9(String c9) {
                this.c9 = c9;
            }

            public String getC6() {
                return c6;
            }

            public void setC6(String c6) {
                this.c6 = c6;
            }

            public String getC3() {
                return c3;
            }

            public void setC3(String c3) {
                this.c3 = c3;
            }

            public Double getLongitude() {
                return longitude;
            }

            public void setLongitude(Double longitude) {
                this.longitude = longitude;
            }

            public String getC16() {
                return c16;
            }

            public void setC16(String c16) {
                this.c16 = c16;
            }

            public String getC10() {
                return c10;
            }

            public void setC10(String c10) {
                this.c10 = c10;
            }
        }

        public static class F1DTO {

            @SerializedName("day_wind_power")
            private String dayWindPower;
            @SerializedName("night_wind_power")
            private String nightWindPower;
            @SerializedName("night_weather_code")
            private String nightWeatherCode;
            @SerializedName("day_weather")
            private String dayWeather;
            @SerializedName("sun_begin_end")
            private String sunBeginEnd;
            @SerializedName("night_weather_pic")
            private String nightWeatherPic;
            @SerializedName("index")
            private IndexDTO index;
            @SerializedName("day_weather_code")
            private String dayWeatherCode;
            @SerializedName("day")
            private String day;
            @SerializedName("night_weather")
            private String nightWeather;
            @SerializedName("ziwaixian")
            private String ziwaixian;
            @SerializedName("jiangshui")
            private String jiangshui;
            @SerializedName("day_wind_direction")
            private String dayWindDirection;
            @SerializedName("night_wind_direction")
            private String nightWindDirection;
            @SerializedName("night_air_temperature")
            private String nightAirTemperature;
            @SerializedName("air_press")
            private String airPress;
            @SerializedName("weekday")
            private Integer weekday;
            @SerializedName("day_weather_pic")
            private String dayWeatherPic;
            @SerializedName("day_air_temperature")
            private String dayAirTemperature;
            private Calendar calendar = Calendar.getInstance();
            private int nowHour = calendar.get(Calendar.HOUR_OF_DAY);
            private boolean isDay = nowHour > 6 && nowHour < 18;
//            public String getAirTemperature(){
//                return isDay?getDayAirTemperature():getNightAirTemperature();
//            }
            public String getWeatherPic(){
                return isDay?getDayWeatherPic():getNightWeatherPic();
            }
            public String getWeather(){
                return isDay?getDayWeather():getNightWeather();
            }
            public String getDayWindPower() {
                return dayWindPower;
            }

            public void setDayWindPower(String dayWindPower) {
                this.dayWindPower = dayWindPower;
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

            public String getDayWeather() {
                return dayWeather;
            }

            public void setDayWeather(String dayWeather) {
                this.dayWeather = dayWeather;
            }

            public String getSunBeginEnd() {
                return sunBeginEnd;
            }

            public void setSunBeginEnd(String sunBeginEnd) {
                this.sunBeginEnd = sunBeginEnd;
            }

            public String getNightWeatherPic() {
                return nightWeatherPic;
            }

            public void setNightWeatherPic(String nightWeatherPic) {
                this.nightWeatherPic = nightWeatherPic;
            }

            public IndexDTO getIndex() {
                return index;
            }

            public void setIndex(IndexDTO index) {
                this.index = index;
            }

            public String getDayWeatherCode() {
                return dayWeatherCode;
            }

            public void setDayWeatherCode(String dayWeatherCode) {
                this.dayWeatherCode = dayWeatherCode;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNightWeather() {
                return nightWeather;
            }

            public void setNightWeather(String nightWeather) {
                this.nightWeather = nightWeather;
            }

            public String getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(String ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public String getJiangshui() {
                return jiangshui;
            }

            public void setJiangshui(String jiangshui) {
                this.jiangshui = jiangshui;
            }

            public String getDayWindDirection() {
                return dayWindDirection;
            }

            public void setDayWindDirection(String dayWindDirection) {
                this.dayWindDirection = dayWindDirection;
            }

            public String getNightWindDirection() {
                return nightWindDirection;
            }

            public void setNightWindDirection(String nightWindDirection) {
                this.nightWindDirection = nightWindDirection;
            }

            public String getNightAirTemperature() {
                return nightAirTemperature;
            }

            public void setNightAirTemperature(String nightAirTemperature) {
                this.nightAirTemperature = nightAirTemperature;
            }

            public String getAirPress() {
                return airPress;
            }

            public void setAirPress(String airPress) {
                this.airPress = airPress;
            }

            public Integer getWeekday() {
                return weekday;
            }

            public void setWeekday(Integer weekday) {
                this.weekday = weekday;
            }

            public String getDayWeatherPic() {
                return dayWeatherPic;
            }

            public void setDayWeatherPic(String dayWeatherPic) {
                this.dayWeatherPic = dayWeatherPic;
            }

            public String getDayAirTemperature() {
                return dayAirTemperature;
            }

            public void setDayAirTemperature(String dayAirTemperature) {
                this.dayAirTemperature = dayAirTemperature;
            }

            public static class IndexDTO {
                @SerializedName("yh")
                private YhDTO yh;
                @SerializedName("zs")
                private ZsDTO zs;
                @SerializedName("cl")
                private ClDTO cl;
                @SerializedName("travel")
                private TravelDTO travel;
                @SerializedName("comfort")
                private ComfortDTO comfort;
                @SerializedName("beauty")
                private BeautyDTO beauty;
                @SerializedName("pj")
                private PjDTO pj;
                @SerializedName("dy")
                private DyDTO dy;
                @SerializedName("nl")
                private NlDTO nl;
                @SerializedName("pk")
                private PkDTO pk;
                @SerializedName("uv")
                private UvDTO uv;
                @SerializedName("ag")
                private AgDTO ag;
                @SerializedName("aqi")
                private AqiDTO aqi;
                @SerializedName("gj")
                private GjDTO gj;
                @SerializedName("mf")
                private MfDTO mf;
                @SerializedName("ls")
                private LsDTO ls;
                @SerializedName("glass")
                private GlassDTO glass;
                @SerializedName("xq")
                private XqDTO xq;
                @SerializedName("ac")
                private AcDTO ac;
                @SerializedName("sports")
                private SportsDTO sports;
                @SerializedName("clothes")
                private ClothesDTO clothes;
                @SerializedName("hc")
                private HcDTO hc;
                @SerializedName("wash_car")
                private WashCarDTO washCar;
                @SerializedName("cold")
                private ColdDTO cold;

                public YhDTO getYh() {
                    return yh;
                }

                public void setYh(YhDTO yh) {
                    this.yh = yh;
                }

                public ZsDTO getZs() {
                    return zs;
                }

                public void setZs(ZsDTO zs) {
                    this.zs = zs;
                }

                public ClDTO getCl() {
                    return cl;
                }

                public void setCl(ClDTO cl) {
                    this.cl = cl;
                }

                public TravelDTO getTravel() {
                    return travel;
                }

                public void setTravel(TravelDTO travel) {
                    this.travel = travel;
                }

                public ComfortDTO getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortDTO comfort) {
                    this.comfort = comfort;
                }

                public BeautyDTO getBeauty() {
                    return beauty;
                }

                public void setBeauty(BeautyDTO beauty) {
                    this.beauty = beauty;
                }

                public PjDTO getPj() {
                    return pj;
                }

                public void setPj(PjDTO pj) {
                    this.pj = pj;
                }

                public DyDTO getDy() {
                    return dy;
                }

                public void setDy(DyDTO dy) {
                    this.dy = dy;
                }

                public NlDTO getNl() {
                    return nl;
                }

                public void setNl(NlDTO nl) {
                    this.nl = nl;
                }

                public PkDTO getPk() {
                    return pk;
                }

                public void setPk(PkDTO pk) {
                    this.pk = pk;
                }

                public UvDTO getUv() {
                    return uv;
                }

                public void setUv(UvDTO uv) {
                    this.uv = uv;
                }

                public AgDTO getAg() {
                    return ag;
                }

                public void setAg(AgDTO ag) {
                    this.ag = ag;
                }

                public AqiDTO getAqi() {
                    return aqi;
                }

                public void setAqi(AqiDTO aqi) {
                    this.aqi = aqi;
                }

                public GjDTO getGj() {
                    return gj;
                }

                public void setGj(GjDTO gj) {
                    this.gj = gj;
                }

                public MfDTO getMf() {
                    return mf;
                }

                public void setMf(MfDTO mf) {
                    this.mf = mf;
                }

                public LsDTO getLs() {
                    return ls;
                }

                public void setLs(LsDTO ls) {
                    this.ls = ls;
                }

                public GlassDTO getGlass() {
                    return glass;
                }

                public void setGlass(GlassDTO glass) {
                    this.glass = glass;
                }

                public XqDTO getXq() {
                    return xq;
                }

                public void setXq(XqDTO xq) {
                    this.xq = xq;
                }

                public AcDTO getAc() {
                    return ac;
                }

                public void setAc(AcDTO ac) {
                    this.ac = ac;
                }

                public SportsDTO getSports() {
                    return sports;
                }

                public void setSports(SportsDTO sports) {
                    this.sports = sports;
                }

                public ClothesDTO getClothes() {
                    return clothes;
                }

                public void setClothes(ClothesDTO clothes) {
                    this.clothes = clothes;
                }

                public HcDTO getHc() {
                    return hc;
                }

                public void setHc(HcDTO hc) {
                    this.hc = hc;
                }

                public WashCarDTO getWashCar() {
                    return washCar;
                }

                public void setWashCar(WashCarDTO washCar) {
                    this.washCar = washCar;
                }

                public ColdDTO getCold() {
                    return cold;
                }

                public void setCold(ColdDTO cold) {
                    this.cold = cold;
                }

                public HashMap<String, BaseDTO> get(){
                    Field[] declaredFields = getClass().getDeclaredFields();

                    HashMap<String, BaseDTO> stringBaseDTOHashMap = new HashMap<>();
                    for (Field declaredField : declaredFields) {
                        declaredField.setAccessible(true);
                        try {
                            stringBaseDTOHashMap.put(declaredField.getName(),(BaseDTO) declaredField.get(this));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return stringBaseDTOHashMap;
                }
                public static class BaseDTO {
                    @SerializedName("desc")
                    private String desc;
                    @SerializedName("title")
                    private String title;

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                }

                public static class YhDTO extends BaseDTO {

                }

                public static class ZsDTO extends BaseDTO{

                }

                public static class ClDTO extends BaseDTO{

                }

                public static class TravelDTO extends BaseDTO{

                }

                public static class ComfortDTO extends BaseDTO{

                }

                public static class BeautyDTO extends BaseDTO{

                }

                public static class PjDTO extends BaseDTO{

                }

                public static class DyDTO extends BaseDTO{

                }

                public static class NlDTO extends BaseDTO{

                }

                public static class PkDTO extends BaseDTO{

                }

                public static class UvDTO extends BaseDTO{

                }

                public static class AgDTO extends BaseDTO{

                }

                public static class AqiDTO extends BaseDTO{

                }

                public static class GjDTO extends BaseDTO{

                }

                public static class MfDTO extends BaseDTO{

                }

                public static class LsDTO extends BaseDTO{

                }

                public static class GlassDTO extends BaseDTO{

                }

                public static class XqDTO extends BaseDTO{

                }

                public static class AcDTO extends BaseDTO{

                }

                public static class SportsDTO extends BaseDTO{

                }

                public static class ClothesDTO extends BaseDTO{

                }

                public static class HcDTO extends BaseDTO{

                }

                public static class WashCarDTO extends BaseDTO{

                }

                public static class ColdDTO extends BaseDTO{

                }
            }
        }
    }
}
