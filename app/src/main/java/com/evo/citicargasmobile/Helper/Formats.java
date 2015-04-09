package com.evo.citicargasmobile.Helper;

import android.net.ParseException;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Daniel on 01/04/2015.
 */
public abstract class Formats {

    private  static final String MASK_CPF = "###.###.###-##";
    private  static final String MASK_CNPJ = "##.###.###/####-##";

    public static String unmask(String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "")
                .replaceAll("[/]", "").replaceAll("[(]", "")
                .replaceAll("[)]", "");
    }

    public static TextWatcher FormatarCpfCnpj( final EditText ediTxt) {
        return new TextWatcher() {
            boolean isUpdating;
            String old = "";

            public void onTextChanged(CharSequence s, int start, int before,int count) {
                String str = unmask(s.toString());
                String mascara = "";
                String mask = "";

                if(str.length() == 11)
                    mask = MASK_CPF;
                else if(str.length() == 14)
                    mask = MASK_CNPJ;

                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }


                int i = 0;
                for (char m : mask.toCharArray()) {
                    if (m != '#' && str.length() > old.length()) {
                        mascara += m;
                        continue;
                    }
                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }

                if(mascara.isEmpty())
                    mascara = str;

                isUpdating = true;
                ediTxt.setText(mascara);
                ediTxt.setSelection(mascara.length());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void afterTextChanged(Editable s) {}
        };
    }

    public static String FormatarCpfCnpj(String cpfCnpj){
        String str = unmask(cpfCnpj.toString());
        String mascara = "";
        String mask = "";

        if(str.length() == 11)
            mask = MASK_CPF;
        else if(str.length() == 14)
            mask = MASK_CNPJ;
        else
            return cpfCnpj;

        int i = 0;
        for (char m : mask.toCharArray()) {
            if (m != '#') {
                mascara += m;
                continue;
            }
            try {
                mascara += str.charAt(i);
            } catch (Exception e) {
                break;
            }
            i++;
        }

        return mascara;
    }

}
