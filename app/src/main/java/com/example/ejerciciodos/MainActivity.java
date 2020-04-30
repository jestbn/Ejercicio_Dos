package com.example.ejerciciodos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public EditText etNombre, etNotaUno, etNotaDos, etNotaTres, etNotaCuatro;
    public TextView tvResultado;
    public ArrayList<Estudiante> estudiantes = new ArrayList<>();
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.etNombre);
        etNotaUno = findViewById(R.id.etNota1);
        etNotaDos = findViewById(R.id.etNota2);
        etNotaTres = findViewById(R.id.etNota3);
        etNotaCuatro = findViewById(R.id.etNota4);
        tvResultado = findViewById(R.id.tvResultado);

    }

    public void CalcularNotas(View view) {
        boolean flag;
        flag = validaciones();
        /* se ha creado un objeto estudiante con las propiedades establecidas de las notas, en el constructor
        de la clase se calcula el promedio debido a que este es el mismo para cada estudiante

        Pero debido a esta implementación no se puede cambiar individualmente las notas del estudiante,
        se tiene que borrar el estudiante y crear otro para actualizar las notas

        Pero no genera problemas debido a que está fuera del alcance del requerimiento
                */
        if (flag) {
            Estudiante estudiante = new Estudiante(etNombre.getText().toString()
                    , Double.parseDouble(etNotaUno.getText().toString())
                    , Double.parseDouble(etNotaDos.getText().toString())
                    , Double.parseDouble(etNotaTres.getText().toString())
                    , Double.parseDouble(etNotaCuatro.getText().toString())
            );
            añadirEstudianteLista(estudiante);
            calcularPerdedores(estudiantes);
        }
    }

    private void calcularPerdedores(ArrayList<Estudiante> estudiantes) {
        //Se inicializa el contador
        int contador = 0;
        //double maxSoFar = estudiantes.get(0).getPromedio();
        try {
            for (Estudiante est : estudiantes) {
                if (est.getPromedio() < 3) {
                    contador++;
                    //maxSoFar = est.getPromedio();
                }
            }
            tvResultado.setText("El número de estudiantes que van perdiendo la materia es: " + contador);
        } catch (Exception e) {
            tvResultado.setText("Ha ocurrido un error contando los perdedores" + e.toString());
        }
    }

    private void añadirEstudianteLista(Estudiante estudiante) {
        try {

            estudiantes.add(estudiante);
        } catch (Exception e) {
            tvResultado.setText("Ha ocurrido un error creando el estudiante" + e.toString());
        }
    }

    private boolean validaciones() {
        boolean auxiliar = true;
        boolean flag[];
        flag = new boolean[4];
        flag[0] = validaciones(etNotaUno);
        flag[1] = validaciones(etNotaDos);
        flag[2] = validaciones(etNotaTres);
        flag[3] = validaciones(etNotaCuatro);
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                auxiliar = false;
            }
        }
        return auxiliar;
    }

    private boolean validaciones(EditText et) {
        boolean flag;
        double minValueInclusive = 0;
        double maxValueInclusive = 5;
        if (TextUtils.isEmpty(et.getText().toString())) {
            //et.setError("El campo no debe estar vacío");
            tvResultado.setText("El campo no debe estar vacío");
            return false;
        }
        double numeroValidar = Double.parseDouble(et.getText().toString());
        if (numeroValidar >= minValueInclusive && numeroValidar <= maxValueInclusive) {
            flag = true;
        } else {
            tvResultado.setText("El siguiente número no está en el rango permitido" + et.getText().toString());
            flag = false;
        }
        return flag;
    }
}
