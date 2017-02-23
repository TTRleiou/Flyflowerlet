package flyflowerlet.ttr.com.flyflowerlet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.io.IOException;
import java.util.Scanner;
import android.widget.Button;
import android.view.View.OnClickListener;








public class Flyflowerlet extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flyflowerlet);

        EditText edout = (EditText) findViewById(R.id.editText2);
        edout.setKeyListener(null);

        Button button = (Button) findViewById(R.id.button);
        Mybutton listener = new Mybutton();
        button.setOnClickListener(listener);
    }
    class Mybutton implements OnClickListener{
        public void onClick(View v) {
            String search = "";
            EditText edt = (EditText) findViewById(R.id.editin);
            EditText edout = (EditText) findViewById(R.id.editText2);
            String now = "";
            search = edt.getText().toString();
            int need = search.length();
            try {
                Scanner scan = new Scanner(getResources().getAssets().open("Tangshi"));
                boolean hadfound = false;
                String ans = "";
                while (scan.hasNext()) {
                    now = scan.nextLine();
                    int l = now.length();
                    if (l == 0) continue;
                    if (now.indexOf("：") != -1) continue;
                    if (now.indexOf(search) != -1) {
                        hadfound = true;
                        ans = ans + now + "\n";
                    }
                }
                if (hadfound) edout.setText(ans);
                else edout.setText("抱歉，没有找到满足要求的诗句");
            } catch (IOException EX) {}
        }
    }

}
