package com.example.oneappsolution.ui.online;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.oneappsolution.AdapterCategories;
import com.example.oneappsolution.Categories;
import com.example.oneappsolution.LoginPage;
import com.example.oneappsolution.R;

import java.util.ArrayList;
import java.util.List;


public class OnlineAppsFragment extends Fragment {

    GridView gridView;
    AdapterCategories adapterCategories;
    List<Categories> categoriesList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_online_apps, container, false);

        categoriesList = new ArrayList<>();
        gridView = root.findViewById(R.id.gridView_categories);

        for (int i = 0; i < 4; i++) {
            categoriesList.add(new Categories(
                    R.drawable.icons8_play_button_96px, "Youtube", null
            ));

            categoriesList.add(new Categories(
                    R.drawable.icons8_google_classroom_96px, "Google Classroom", null
            ));

            categoriesList.add(new Categories(
                    R.drawable.icons8_student_male_96px, "e-Learn", null
            ));
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String category_name = categoriesList.get(position).getCategory();

                if (category_name.equals("Youtube")) {
                    Intent intent = new Intent(getContext(), LoginPage.class);
                    startActivity(intent);
                    Toast t = Toast.makeText(getActivity(), "Welcome to Youtube", Toast.LENGTH_LONG);
                    t.show();

                } else if (category_name.equals("Google Classroom")) {
                    //Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_meat_and_fish);
                    Toast t = Toast.makeText(getActivity(), "Welcome to Google Classroom", Toast.LENGTH_LONG);
                    t.show();
                } else if (category_name.equals("e-Learn")) {
                    //Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.nav_grocery_items);
                    Toast t = Toast.makeText(getActivity(), "Welcome to e-Learn", Toast.LENGTH_LONG);
                    t.show();
                }

            }
        });

        adapterCategories = new AdapterCategories(getActivity(), categoriesList);
        gridView.setAdapter(adapterCategories);

        return root;
    }
}