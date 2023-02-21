package com.zoneproduction.library.GlavniScreenovi;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zoneproduction.library.Knjige.AdventureCategory;
import com.zoneproduction.library.Knjige.ArtCategory;
import com.zoneproduction.library.Knjige.BiographyCategory;
import com.zoneproduction.library.Knjige.ChildrenCategory;
import com.zoneproduction.library.Knjige.ComediesCategory;
import com.zoneproduction.library.Knjige.FantasyCategory;
import com.zoneproduction.library.Knjige.FinancialCategory;
import com.zoneproduction.library.Knjige.HistoryCategory;
import com.zoneproduction.library.Knjige.HorrorCategory;
import com.zoneproduction.library.Knjige.MotivationalCategory;
import com.zoneproduction.library.Knjige.MysteryCategory;
import com.zoneproduction.library.Knjige.PoetryCategory;
import com.zoneproduction.library.Knjige.ReligionCategory;
import com.zoneproduction.library.Knjige.RomanceCategory;
import com.zoneproduction.library.Knjige.SciFiCategory;
import com.zoneproduction.library.R;

public class FragmentLibraryWriter extends Fragment {

    public static FragmentLibraryWriter newInstance() {

        return new FragmentLibraryWriter();
    }

    ImageView imageFantasy, imageAdventure, imageMystery, imageRomance, imageHorror, imageReligion , imageBios, imagePoetry;
    ImageView imageSciFi, imageChildren, imageArt, imageMotivational,  imageFinancial, imageHistory, imageComedies;

    HomeScreenReader hsr = new HomeScreenReader();
    String type = hsr.getType();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_library_writer, container, false);
        imageAdventure = view.findViewById(R.id.imageAction2);
        imageArt = view.findViewById(R.id.imageArtHow2);
        imageFantasy = view.findViewById(R.id.imageFantasy2);
        imageMystery = view.findViewById(R.id.imageMystery2);
        imageRomance = view.findViewById(R.id.imageRomance2);
        imageHorror = view.findViewById(R.id.imageHorror2);
        imageReligion = view.findViewById(R.id.imageReligion2);
        imageBios = view.findViewById(R.id.imageBiographies2);
        imagePoetry = view.findViewById(R.id.imagePoetry2);
        imageSciFi = view.findViewById(R.id.imageSciFi2);
        imageChildren = view.findViewById(R.id.imageChildren2);
        imageMotivational = view.findViewById(R.id.imageMotivational2);
        imageFinancial = view.findViewById(R.id.imageFinancial2);
        imageHistory = view.findViewById(R.id.imageHistory2);
        imageComedies = view.findViewById(R.id.imageComedies2);

        imageAdventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), AdventureCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), ArtCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageFantasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), FantasyCategory.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        imageMystery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), MysteryCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageHorror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), HorrorCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageRomance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), RomanceCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageReligion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), ReligionCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageBios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), BiographyCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imagePoetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), PoetryCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageSciFi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), SciFiCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), ChildrenCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageMotivational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), MotivationalCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageFinancial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), FinancialCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });
        imageHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), HistoryCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageComedies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), ComediesCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        return view;

    }
}