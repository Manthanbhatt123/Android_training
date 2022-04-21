package com.example.mapapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback
{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//
//		String url=makeURL(23.02413186, 72.57019043, 21.77065941, 72.14687347);
//		Log.i("URL",""+url);
//
//		new connectAsyncTask(url).execute();

		if(!isNetworkConnected())
			Toast.makeText(getApplicationContext(),"Please check your Internet connection",Toast.LENGTH_LONG).show();
		else
			Toast.makeText(getApplicationContext(),"Internet connection available",Toast.LENGTH_LONG).show();
    }

	private boolean isNetworkConnected()
	{
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
	}

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
//        LatLng marker = new LatLng(location.getLatitude(),  location.getLongitude());
        mMap.clear();
//        mMap.addMarker(new MarkerOptions().position(marker).title("Marker in Ahmedabad"));
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 25.0f));
    }

    public String makeURL (double sourcelat, double sourcelog, double destlat, double destlog )
	{
        StringBuilder urlString = new StringBuilder();
        urlString.append("https://maps.googleapis.com/maps/api/directions/json");
        urlString.append("?origin=");// from
        urlString.append(Double.toString(sourcelat));
        urlString.append(",");
        urlString
                .append(Double.toString( sourcelog));
        urlString.append("&destination=");// to
        urlString
                .append(Double.toString( destlat));
        urlString.append(",");
        urlString.append(Double.toString( destlog));
        urlString.append("&sensor=false&mode=driving&alternatives=true");
        return urlString.toString();
 }

	public void drawPath(String  result)
	{
	    try {
	           final JSONObject json = new JSONObject(result);
	           JSONArray routeArray = json.getJSONArray("routes");
	           JSONObject routes = routeArray.getJSONObject(0);
	           JSONObject overviewPolylines = routes.getJSONObject("overview_polyline");
	           String encodedString = overviewPolylines.getString("points");
	           List<LatLng> list = decodePoly(encodedString);

	           for(int z = 0; z<list.size()-1;z++)
	           {
	                LatLng src= list.get(z);
	                LatLng dest= list.get(z+1);
	                Polyline line = mMap.addPolyline(new PolylineOptions()
	                .add(new LatLng(src.latitude, src.longitude), new LatLng(dest.latitude,   dest.longitude))
	                .width(5)
	                .color(Color.BLUE).geodesic(true));
	            }

	    }
	    catch (Exception  e) {

	    }
	}
	private List<LatLng> decodePoly(String encoded)
	{
	    List<LatLng> poly = new ArrayList<LatLng>();
	    int index = 0, len = encoded.length();
	    int lat = 0, lng = 0;

	    while (index < len) {
	        int b, shift = 0, result = 0;
	        do {
	            b = encoded.charAt(index++) - 63;
	            result |= (b & 0x1f) << shift;
	            shift += 5;
	        } while (b >= 0x20);
	        int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
	        lat += dlat;

	        shift = 0;
	        result = 0;
	        do {
	            b = encoded.charAt(index++) - 63;
	            result |= (b & 0x1f) << shift;
	            shift += 5;
	        } while (b >= 0x20);
	        int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
	        lng += dlng;

	        LatLng p = new LatLng( (((double) lat / 1E5)),
	                 (((double) lng / 1E5) ));
	        poly.add(p);
	    }

	    return poly;
	}


	class connectAsyncTask extends AsyncTask<Void, Void, String>
	{
	    private ProgressDialog progressDialog;
	    String url;
	    connectAsyncTask(String urlPass){
	        url = urlPass;
	    }
	    @Override
	    protected void onPreExecute()
	    {
	        super.onPreExecute();
	        progressDialog = new ProgressDialog(MainActivity.this);
	        progressDialog.setMessage("Fetching route, Please wait...");
	        progressDialog.setIndeterminate(true);
	        progressDialog.show();
	    }
	    @Override
	    protected String doInBackground(Void... params)
	    {
	        JSONParser jParser = new JSONParser();
	        String json = jParser.getJSONFromUrl(url);
	        return json;
	    }
	    @Override
	    protected void onPostExecute(String result)
	                                                                                                                                                                                                                                                                                                                              {
	        super.onPostExecute(result);
	        progressDialog.hide();
	        if(result!=null){
	            drawPath(result);
	        }
	    }
	}
}