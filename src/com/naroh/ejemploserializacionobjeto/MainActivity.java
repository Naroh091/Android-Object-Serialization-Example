package com.naroh.ejemploserializacionobjeto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{
	protected Alumno a;
	// Nombre del archivo donde vamos a guardar el objeto
	protected String filename = "alumno.dat"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Creamos un alumno e introducimos los datos de prueba

		a = new Alumno();
		a.setNombre("Juan");
		a.setApellido("Cuesta");
		ArrayList<String> asignaturas = new ArrayList<String>();
		asignaturas.add("Introducción a la Ley de Propiedad Horizontal");
		asignaturas.add("Gestión de infraestructuras comunitarias");
		asignaturas.add("Recursos humanos");
		asignaturas.add("Principios históricos en la restauración de fachadas");
		a.setAsignaturas(asignaturas);
		a.setNotamedia(8.4);
		a.setPasadecurso(true);


		// Añadimos onClickListeners a los dos botones con las acciones que deben realizar

		Button serializa = (Button) findViewById(R.id.serializar);
		serializa.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("A", "tocado serializa");
				Serializa(a);
			}
		});

		Button desserializa = (Button) findViewById(R.id.deserializar);
		desserializa.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Desserializa();

			}
		});
	}

	protected void Serializa(Alumno a){
		FileOutputStream fos;
		try {
			fos = openFileOutput(filename, Context.MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.close();
			Toast.makeText(this, "Objeto correctamente serializado y guardado", Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException e) {
			Toast.makeText(this, "Error: archivo no encontrado", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		} 
		catch (IOException e) {
			Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
	}

	protected void Desserializa(){
		FileInputStream fin;
		Alumno afromfile = null;

		try {
			fin = openFileInput(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			afromfile = (Alumno) ois.readObject();
			ois.close();
			Toast.makeText(this, "Objeto des-serializado y extraído", Toast.LENGTH_SHORT).show();
		} catch (StreamCorruptedException e) {
			Toast.makeText(this, "Error en las comprobaciones de consistencia", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		} catch (OptionalDataException e) {
			Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			Toast.makeText(this, "Archivo no encontrado", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		} catch (IOException e) {
			Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TextView texto = (TextView) findViewById(R.id.textodesserializado);
		if(afromfile != null) texto.setText(afromfile.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
