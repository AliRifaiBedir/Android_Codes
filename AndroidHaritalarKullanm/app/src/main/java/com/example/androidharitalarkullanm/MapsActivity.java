package com.example.androidharitalarkullanm;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    static final LatLng BESIKTAS = new LatLng(41.042971, 29.002019);
    static final LatLng ÜSKÜDAR = new LatLng(41.034074, 29.032335);

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
       // LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
       //  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        //Aşağıda yazdığımız kodlarla iki yerin pozisyonunu
        //gösteren bir uygulama yaptık.Sşimdi onu yorum
        //satırı yapıyoruz çünkü şimdi aşağıdaki 2 nokta arası çizim yapcaz
      /*  if (mMap != null) {

            mMap.addMarker(new MarkerOptions().position(BESIKTAS)
                    .title("Beşiktaş"));//Başlık
            mMap.addMarker(new MarkerOptions().position(ÜSKÜDAR)
                    .title("Üsküdar")//Başlık
                    .snippet("Tarihi Yerlere sahip")//Açıklama
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_round)));

        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BESIKTAS, 12));
        //Kamera ne kadar yüksekste olsun
        //(İlk açılınca nereyi göstersin,Ne Kadar yüksekte olsun kamera)

        */



        if (mMap != null) {

            mMap.addMarker(new MarkerOptions().position(BESIKTAS)
                    .title("Beşiktaş"));//Başlık
            mMap.addMarker(new MarkerOptions().position(ÜSKÜDAR)
                    .title("Üsküdar")//Başlık
                    .snippet("Tarihi Yerlere sahip")//Açıklama
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_round)));

            PolylineOptions options=new PolylineOptions().add(ÜSKÜDAR).add(BESIKTAS).width(5).color(Color.BLUE).visible(true).geodesic(true);
            mMap.addPolyline(options);
            //Böylece iki nokta arasında mavi bir çizgi çizdik

            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            //Böylece direk uydu görünümü olur

            mMap.setTrafficEnabled(true);
            //Trafik Durumunu Gösterir

            mMap.setMyLocationEnabled(true);
            //Yerimizi gösterir

            UiSettings uis=googleMap.getUiSettings();
            uis.setCompassEnabled(true);
            //pusula gösterilsin mi

            uis.setZoomControlsEnabled(true);
            //Zoom özelliği

            uis.setMyLocationButtonEnabled(true);
            //Kendi konumumuz


            addMarker("Yeni Yer",41.0255,28.0658);


            mMap.setOnMyLocationChangeListener(new LocationGözlemci());
            //Bulunduğumuz yer sınıfını böyle çağıracaz ve bunun sayesinde
            //ben hareket edince benle hareket edecek

        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BESIKTAS, 12));
        //Kamera ne kadar yüksekste olsun
        //(İlk açılınca nereyi göstersin,Ne Kadar yüksekte olsun kamera)

    }

    //Burada parametre olaarak girdiğmiiz yere işaret koyacaz
    private void addMarker(String title,double latitude,double longtitude){

        MarkerOptions m =new MarkerOptions();
        m.title(title);
        m.draggable(true);
        m.position(new LatLng(latitude,longtitude));
        mMap.addMarker(m);



    }

    //Burada farklı bir sınıf olusturduk amac cihazın yer değiştirmesini takip etmek için
    public  class LocationGözlemci implements GoogleMap.OnMyLocationChangeListener{
        //Cihazın yer değiştirmesini izlemek için kullanılan sınıf bu




        @Override
        public void onMyLocationChange(Location location) {
            LatLng loc=new LatLng(location.getLatitude(),location.getLongitude());
            Projection p =mMap.getProjection();
            Point point=p.toScreenLocation(loc);

            CircleOptions circle=new CircleOptions();
            circle.center(loc);
            circle.fillColor(Color.RED);//RENK
            circle.radius(10);
            circle.strokeWidth(1);//KENAR KALINLIĞI
            mMap.addCircle(circle);

        }
    }





}
