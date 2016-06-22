package org.grupovision.visioncontacts;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Contact contact = new Contact("Olvin A. Garcia","Grupo Visión", "+504 9512-0158",
            "agarcia@grupovision.org","olvingarcia","olvingarcia2a","@olvingarcia","img_olvin");

    private ImageView imgView;
    private TextView txtName, txtCompany, txtTelephone, txtEmail, txtGithub, txtFacebook, txtTwitter;
    private ImageButton btnPhone, btnEmail, btnGithub, btnFacebook, btnTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (ImageView) findViewById(R.id.imgView);
        txtName = (TextView) findViewById(R.id.txtName);
        txtCompany = (TextView) findViewById(R.id.txtCompany);
        txtTelephone= (TextView) findViewById(R.id.txtTelephone);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtGithub= (TextView) findViewById(R.id.txtGithub);
        txtFacebook = (TextView) findViewById(R.id.txtFacebook);
        txtTwitter= (TextView) findViewById(R.id.txtTwitter);

        btnPhone = (ImageButton)findViewById(R.id.btnPhone);
        btnEmail  = (ImageButton)findViewById(R.id.btnEmail);
        btnGithub  = (ImageButton)findViewById(R.id.btnGithub);
        btnFacebook  = (ImageButton)findViewById(R.id.btnFacebook);
        btnTwitter  = (ImageButton)findViewById(R.id.btnTwitter);

        btnPhone.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnGithub.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        btnTwitter.setOnClickListener(this);

        txtName.setText(contact.getName());
        txtCompany.setText(contact.getCompany());
        txtTelephone.setText(contact.getTelephone());
        txtEmail.setText(contact.getEmail());
        txtGithub.setText(contact.getGithub());
        txtFacebook.setText(contact.getFacebook());
        txtTwitter.setText(contact.getTwitter());

        Resources recourses = getApplicationContext().getResources();
        final int resourceId = recourses.getIdentifier(contact.getPhoto(),"drawable", getApplicationContext().getPackageName());
        imgView.setImageDrawable(recourses.getDrawable(resourceId));

    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId())
        {
            case R.id.btnPhone:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ contact.getTelephone()));

                if (getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_TELEPHONY))
                {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                    {
                        Toast.makeText(this, "No tienes permiso para usar el telefono", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else
                        startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, "El dispositivo no tiene el hardware", Toast.LENGTH_SHORT).show();
                }
                break;

            case  R.id.btnEmail:

                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:agarcia@grupovision.org"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Test");
                intent.putExtra(Intent.EXTRA_TEXT,"Este es un correo de prueba");
                startActivity(intent);
                break;

            case R.id.btnTwitter:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=ogarcia2a"));
                try
                {
                    startActivity(intent);
                }
                catch (ActivityNotFoundException e)
                {
                    intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=com.twitter.android"));
                    try {
                        startActivity(intent);
                    }
                    catch (ActivityNotFoundException er)
                    {
                        Toast.makeText(this,"Necesitas tener Play Store", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

        }
    }
}
