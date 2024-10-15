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

public class RegisterFragment extends Fragment {
    private EditText username, email, phone, password;
    private Button registerButton;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Inisialisasi View
        username = view.findViewById(R.id.registerUsername
        );
        email = view.findViewById(R.id.registerEmail);
        phone = view.findViewById(R.id.registerPhone);
        password = view.findViewById(R.id.registerPassword);
        registerButton = view.findViewById(R.id.registerButton);

        // Set Listener untuk Button Register
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validasi dan logika pendaftaran
                if (isValidRegistration()) {
                    // Berpindah ke HomeFragment setelah pendaftaran suks
                    Fragment homeFragment = new HomeFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, homeFragment); // R.id.fragment_container adalah ID dari container di layout Activity Anda
                    transaction.addToBackStack(null); // Menambahkan ke backstack agar bisa kembali ke fragment sebelumnya
                    transaction.commit(); // Menjalankan transaksi
                }
            }
        });

        return view;
    }

    // Fungsi validasi pendaftaran
    private boolean isValidRegistration() {
        // Contoh validasi sederhana
        return !username.getText().toString().isEmpty() &&
                !email.getText().toString().isEmpty() &&
                !phone.getText().toString().isEmpty() &&
                !password.getText().toString().isEmpty();
    }
}
