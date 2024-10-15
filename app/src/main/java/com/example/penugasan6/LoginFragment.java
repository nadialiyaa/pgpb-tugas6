package com.example.penugasan6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment {
    private EditText username, password;
    private Button loginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Inisialisasi View
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        loginButton = view.findViewById(R.id.loginButton);

        // Set Listener untuk Button Login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validasi dan logika login
                if (isValidLogin()) {
                    // Berpindah ke HomeFragment menggunakan FragmentTransaction
                    Fragment homeFragment = new HomeFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, homeFragment); // R.id.fragment_container adalah ID dari container di layout Activity Anda
                    transaction.addToBackStack(null); // Menambahkan ke backstack
                    transaction.commit(); // Menjalankan transaksi
                }
            }
        });

        return view;
    }

    // Fungsi validasi login
    private boolean isValidLogin() {
        // Contoh validasi sederhana
        return !username.getText().toString().isEmpty() &&
                !password.getText().toString().isEmpty();
    }
}
