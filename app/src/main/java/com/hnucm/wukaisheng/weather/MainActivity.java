package com.hnucm.wukaisheng.weather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hnucm.wukaisheng.weather.API.WeatherService;
import com.hnucm.wukaisheng.weather.utils.RetrofitUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText address;
    TextView temperature;
    TextView cloudCover;
    TextView jiangshui;
    RecyclerView fifteenDaysWeather;
    RecyclerView hour24;
    RecyclerView advice;
    TextView button;
    TextView wind;
    TextView windpower;
    TextView sunrise;
    TextView sunset;
    TextView humidity;
    TextView feelthetemperature;
    TextView uv;
    TextView atmosphericpressure;
    ImageView weatherImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        address = findViewById(R.id.address);
        temperature = findViewById(R.id.temperature);
        cloudCover = findViewById(R.id.cloudcover);
        jiangshui = findViewById(R.id.jiangshui);
        fifteenDaysWeather = findViewById(R.id.Fifteendaysweather);
        hour24 = findViewById(R.id.hour24);
        advice = findViewById(R.id.Lifeadvice);
        button = findViewById(R.id.textView13);
        wind = findViewById(R.id.Wind);
        windpower = findViewById(R.id.windpower);
        sunrise = findViewById(R.id.sunrise);
        sunset = findViewById(R.id.sunset);
        humidity = findViewById(R.id.humidity);
        feelthetemperature = findViewById(R.id.Feelthetemperature);
        uv = findViewById(R.id.Ultraviolet);
        atmosphericpressure = findViewById(R.id.atmosphericpressure);
        weatherImg = findViewById(R.id.weatherImg);
        WeatherService weatherService = RetrofitUtils.
                getRetrofit("https://ali-weather.showapi.com/").create(WeatherService.class);
        String token = "APPCODE "+MyAppCode.APPCODE;

        extracted(weatherService, token);
        button.setOnClickListener(v -> extracted(weatherService, token));
    }

    private void extracted(WeatherService weatherService, String token) {
        String area;
        if (address.getText().toString().isEmpty()) {
//            area="长沙";
            area = "北京";
        } else {
            area = address.getText().toString();
        }
        Call<SevenDaysInTheFuture> sevenDaysCall = weatherService.getSevenDaysInTheFutureData(token, area);
        sevenDaysCall.enqueue(new Callback<SevenDaysInTheFuture>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<SevenDaysInTheFuture> call, Response<SevenDaysInTheFuture> response) {
                SevenDaysInTheFuture.ShowapiResBodyDTO.F1DTO f1 = null;
                if (response.body() != null) {
                    f1 = response.body().getShowapiResBody().getF1();
                    SevenDaysInTheFuture.ShowapiResBodyDTO.F1DTO finalF = f1;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            cloudCover.setText(finalF.getWeather() + " ");
                            jiangshui.setText("降水 " + finalF.getJiangshui());
                            sunrise.setText("日出时间 "+finalF.getSunBeginEnd().split("\\|")[0]);
                            sunset.setText("日落时间 "+finalF.getSunBeginEnd().split("\\|")[1]);
                            humidity.setText("降水 " + finalF.getJiangshui());
                            feelthetemperature.setText("体感气温 " + finalF.getDayAirTemperature());
                            uv.setText("紫外线 " + finalF.getZiwaixian());
                            atmosphericpressure.setText("气压 " + finalF.getAirPress());
                            Glide.with(MainActivity.this)
                                    .load(finalF.getWeatherPic())
                                    .into(weatherImg);
                        }
                    });

                    HashMap<String, SevenDaysInTheFuture.ShowapiResBodyDTO.F1DTO.IndexDTO.BaseDTO> stringBaseDTOHashMap = f1.getIndex().get();
                    List<String> key = new ArrayList<>(stringBaseDTOHashMap.keySet());
                    List<SevenDaysInTheFuture.ShowapiResBodyDTO.F1DTO.IndexDTO.BaseDTO> value = new ArrayList<>(stringBaseDTOHashMap.values());
                    AdviceAdaptor adviceAdaptor = new AdviceAdaptor(key, value);
                    advice.setAdapter(adviceAdaptor);
                    advice.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adviceAdaptor.notifyDataSetChanged();
                } else if(!address.getText().toString().isEmpty()) {
                    MainActivity.this.requestErr();
                }

            }

            @Override
            public void onFailure(Call<SevenDaysInTheFuture> call, Throwable t) {

            }
        });
        Call<Day15> day15Call = weatherService.getDay15Data(token, area);
        day15Call.enqueue(new Callback<Day15>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<Day15> call, Response<Day15> response) {
                Day15.ShowapiResBodyDTO showapiResBody = null;
                if (response.body() != null) {
                    showapiResBody = response.body().getShowapiResBody();
                    FifteenDaysWeatherAdaptor fifteenDaysWeatherAdaptor = new FifteenDaysWeatherAdaptor(showapiResBody.getDayList());
                    fifteenDaysWeather.setAdapter(fifteenDaysWeatherAdaptor);
                    fifteenDaysWeather.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    fifteenDaysWeatherAdaptor.notifyDataSetChanged();
                } else if(!address.getText().toString().isEmpty()) {
                    MainActivity.this.requestErr();
                }

            }

            @Override
            public void onFailure(Call<Day15> call, Throwable t) {

            }
        });
        Call<Hour24> hour24Call = weatherService.getHour24Data(token, area);
        hour24Call.enqueue(new Callback<Hour24>() {
            @Override
            public void onResponse(Call<Hour24> call, Response<Hour24> response) {
                Hour24.ShowapiResBodyDTO showapiResBody = null;
                if (response.body() != null) {
                    showapiResBody = response.body().getShowapiResBody();
                    Hour24Adaptor hour24Adaptor = new Hour24Adaptor(showapiResBody.getHourList());
                    hour24.setAdapter(hour24Adaptor);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    hour24.setLayoutManager(linearLayoutManager);
                    hour24Adaptor.notifyDataSetChanged();
                    for (Hour24.ShowapiResBodyDTO.HourListDTO hourListDTO : showapiResBody.getHourList()) {

                        SimpleDateFormat HHsdf = new SimpleDateFormat("HH");
//                            String format = HHsdf.format(new Date());
                        Calendar instance = Calendar.getInstance();

                        String substring = hourListDTO.getTime().substring(8, 10);
                        if (instance.get(Calendar.HOUR_OF_DAY) == Integer.parseInt(substring)) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    temperature.setText(hourListDTO.getTemperature() + "°");
                                    wind.setText("风向 "+hourListDTO.getWindDirection());
                                    windpower.setText("风力 "+hourListDTO.getWindPower());
                                }
                            });
                        } else if(!address.getText().toString().isEmpty()) {
                            MainActivity.this.requestErr();
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<Hour24> call, Throwable t) {

            }
        });
    }

    private void requestErr() {
        Toast.makeText(MainActivity.this, "没有找到这个城市哦", Toast.LENGTH_SHORT).show();
    }


    private class AdviceAdaptor extends RecyclerView.Adapter<AdviceAdaptor.Holder> {
        //        List<HashMap<String, SevenDaysInTheFuture.ShowapiResBodyDTO.F1DTO.IndexDTO.BaseDTO>> data;
        List<String> keyData;
        List<SevenDaysInTheFuture.ShowapiResBodyDTO.F1DTO.IndexDTO.BaseDTO> valueDta;
        HashMap<String, String> trainslateHashMap = new HashMap<>();

        public AdviceAdaptor(List<String> keyData, List<SevenDaysInTheFuture.ShowapiResBodyDTO.F1DTO.IndexDTO.BaseDTO> valueDta) {
            this.keyData = keyData;
            this.valueDta = valueDta;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.item_advice, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            init(trainslateHashMap);
            for (String keyDatum : keyData) {
                Log.i("Keytest", "onBindViewHolder: "+keyDatum);
            }
            holder.cate.setText(trainslateHashMap.get(keyData.get(position)));
            SevenDaysInTheFuture.ShowapiResBodyDTO.F1DTO.IndexDTO.BaseDTO baseDTO = valueDta.get(position);
            holder.title.setText(baseDTO.getTitle());
            holder.desc.setText(baseDTO.getDesc());
//            HashMap<String, SevenDaysInTheFuture.ShowapiResBodyDTO.F1DTO.IndexDTO.BaseDTO> stringBaseDTOHashMap = valueDta.get(position);
//            holder.cate.setText(trainslateHashMap.get(stringBaseDTOHashMap.keySet()));
//            holder.title.setText(stringBaseDTOHashMap.get(stringBaseDTOHashMap.keySet()).getTitle());
//            holder.title.setText(stringBaseDTOHashMap.get(stringBaseDTOHashMap.keySet()).getDesc());
        }

        private void init(HashMap<String, String> trainslateHashMap) {
            trainslateHashMap.put("yh", "约会指数");
            trainslateHashMap.put("zs", "中暑指数");
            trainslateHashMap.put("cl", "晨练指数");
            trainslateHashMap.put("travel", "旅游");
            trainslateHashMap.put("comfort", "舒适");
            trainslateHashMap.put("beauty", "化妆指数");
            trainslateHashMap.put("pj", "啤酒指数");
            trainslateHashMap.put("dy", "钓鱼指数");
            trainslateHashMap.put("nl", "夜生活指数");
            trainslateHashMap.put("pk", "放风筝指数");
            trainslateHashMap.put("uv", "紫外线");
            trainslateHashMap.put("ag", "过敏指数");
            trainslateHashMap.put("aqi", "大气污染");
            trainslateHashMap.put("gj", "逛街指数");
            trainslateHashMap.put("mf", "美发指数");
            trainslateHashMap.put("ls", "晾晒指数");
            trainslateHashMap.put("glass", "太阳镜");
            trainslateHashMap.put("xq", "心情指数");
            trainslateHashMap.put("ac", "空调控制");
            trainslateHashMap.put("sports", "运动");
            trainslateHashMap.put("clothes", "穿着");
            trainslateHashMap.put("hc", "划船指数");
            trainslateHashMap.put("washCar", "洗车");
            trainslateHashMap.put("cold", "感冒");
        }

        @Override
        public int getItemCount() {
            return keyData.size();
        }

        private class Holder extends RecyclerView.ViewHolder {
            TextView cate;
            TextView desc;
            TextView title;

            public Holder(@NonNull View itemView) {
                super(itemView);
                cate = itemView.findViewById(R.id.textView9);
                desc = itemView.findViewById(R.id.textView11);
                title = itemView.findViewById(R.id.textView10);
            }
        }
    }

    private class Hour24Adaptor extends RecyclerView.Adapter<Hour24Adaptor.Holder> {
        List<Hour24.ShowapiResBodyDTO.HourListDTO> data;

        public Hour24Adaptor(List<Hour24.ShowapiResBodyDTO.HourListDTO> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.item_hour24, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            Hour24.ShowapiResBodyDTO.HourListDTO hourListDTO = data.get(position);
            holder.temperature.setText(hourListDTO.getTemperature()+"°");
            holder.weather.setText(hourListDTO.getWeather());
            holder.windPower.setText(hourListDTO.getWindPower());
            holder.windDirection.setText(hourListDTO.getWindDirection());
            holder.time.setText(hourListDTO.getFormattedTime());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        private class Holder extends RecyclerView.ViewHolder {
            TextView temperature;
            TextView weather;
            TextView windPower;
            TextView windDirection;
            TextView time;

            public Holder(@NonNull View itemView) {
                super(itemView);
                temperature = itemView.findViewById(R.id.textView);
                weather = itemView.findViewById(R.id.textView12);
                windPower = itemView.findViewById(R.id.textView6);
                windDirection = itemView.findViewById(R.id.textView7);
                time = itemView.findViewById(R.id.textView8);
            }
        }
    }

    private class FifteenDaysWeatherAdaptor extends RecyclerView.Adapter<FifteenDaysWeatherAdaptor.Holder> {
        List<Day15.ShowapiResBodyDTO.DayListDTO> data;

        public FifteenDaysWeatherAdaptor(List<Day15.ShowapiResBodyDTO.DayListDTO> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.item_fifteendaysweather, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            Day15.ShowapiResBodyDTO.DayListDTO dayListDTO = data.get(position);


            String imgUrl = dayListDTO.getWeatherPic();
            Glide.with(MainActivity.this)
                    .load(imgUrl)
                    .into(holder.weatherImg);

            holder.day.setText(dayListDTO.getDay(position, dayListDTO));
            holder.weather.setText(dayListDTO.getWeather());
            holder.wind.setText(dayListDTO.getWind());
            holder.temperature.setText(dayListDTO.getAirTemperature());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        private class Holder extends RecyclerView.ViewHolder {
            ImageView weatherImg;
            TextView day;
            TextView weather;
            TextView wind;
            TextView temperature;

            public Holder(@NonNull View itemView) {
                super(itemView);
                weatherImg = itemView.findViewById(R.id.imageView);
                day = itemView.findViewById(R.id.day);
                weather = itemView.findViewById(R.id.textView2);
                wind = itemView.findViewById(R.id.textView5);
                temperature = itemView.findViewById(R.id.textView3);
            }
        }
    }
}