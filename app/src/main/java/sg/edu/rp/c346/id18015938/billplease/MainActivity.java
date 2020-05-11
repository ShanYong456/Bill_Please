package sg.edu.rp.c346.id18015938.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    EditText pax;
    ToggleButton sys;
    ToggleButton gst;
    EditText discount;
    TextView bill;
    TextView each;
    Button reset;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = findViewById (R.id.input_amount);
        pax = findViewById(R.id.num_pax);
        sys = findViewById(R.id.sys);
        gst = findViewById(R.id.gst);
        discount = findViewById(R.id.discount_input);
        bill = findViewById(R.id.total_bill);
        each = findViewById(R.id.each);
        reset = findViewById(R.id.reset);
        calculate = findViewById(R.id.calculate);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code for the action
                Double current_bill = Double.parseDouble(amount.getText().toString());


                if (sys.isChecked()==true && gst.isChecked()==false){
                     current_bill = current_bill * 1.1;
                 }


                 else if (sys.isChecked()==false && gst.isChecked()==true){
                    current_bill = current_bill * 1.07;
                 }

                 else if (sys.isChecked()==true && gst.isChecked()==true){
                     current_bill = current_bill * 1.17;
                 }




                double discount_percent = Double.parseDouble(discount.getText().toString());
                if(discount_percent!=0){
                    double discount_price = current_bill * ((1 - (discount_percent/100)));
                    bill.setText("Total Bill: $"+String.valueOf(discount_price));

                }else{
                    bill.setText("Total Bill: $"+String.valueOf(current_bill));
                }


                String p = pax.getText().toString();
                int num_pax = Integer.parseInt(p);
                double split_price = current_bill / num_pax;
                each.setText("Each person pay $"+String.valueOf(split_price));

            }



        });



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code for the action
                bill.setText("Bill: $0");
                each.setText("Each person pay $0");
                amount.setText("");
                pax.setText("");
                discount.setText("");
                sys.setChecked(false);
                gst.setChecked(false);


            }
        });



    }


}
