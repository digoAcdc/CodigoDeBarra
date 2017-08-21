package br.com.barbosa.rodrigo.codigodebarra.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.barbosa.rodrigo.codigodebarra.R;
import br.com.barbosa.rodrigo.codigodebarra.adapter.ListScannerAdapter;
import br.com.barbosa.rodrigo.codigodebarra.model.Scanners;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListScannersActivity extends AppCompatActivity {

    @BindView(R.id.rvScanners)
    protected RecyclerView rvScanners;

    private LinearLayoutManager mLayoutManager;
    private ListScannerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_scanners);

        ButterKnife.bind(this);

        initRecyclerView();
        //isto devera ser um servico
        mAdapter.addAll(buscaDados());
    }

    private List<Scanners> buscaDados() {
        List<Scanners> lst = new ArrayList<>();
        for (int i = 0; i<8; i++){
            Scanners s = new Scanners();
            s.setId(i);
            s.setTitulo("Pesquisar pelo tipo de scanner " + String.valueOf(i));
            lst.add(s);
        }


        return lst;
    }

    private void initRecyclerView() {
        mAdapter = new ListScannerAdapter(this, onClickScanner());

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvScanners.setLayoutManager(mLayoutManager);
        rvScanners.setLayoutManager(mLayoutManager);
        rvScanners.setNestedScrollingEnabled(false);
        rvScanners.setItemAnimator(new DefaultItemAnimator());
        rvScanners.setAdapter(mAdapter);
    }

    private ListScannerAdapter.ScannerOnClickListener onClickScanner() {
        return new ListScannerAdapter.ScannerOnClickListener() {
            @Override
            public void OnClickScanner(View view, int index) {
                Toast.makeText(ListScannersActivity.this, "index clicado" + String.valueOf(index), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ListScannersActivity.this, MainActivity.class);
                startActivity(i);
            }
        };
    }


}
