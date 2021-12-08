package com.test.testtasklteh.PhoneMaskUtils;

import android.widget.EditText;

import com.github.vacxe.phonemask.PhoneMaskManager;

public class EditPhoneMask {
    private PhoneMaskManager phoneMaskManager;
    private String region;

    public void createMaskFromServer(String mask, EditText editText) {
        String newMask = "";
        String[] maskSplit = mask.split(" ");
        for (int i = 1; i < maskSplit.length; i++) {
            newMask = newMask.concat(" ").concat(maskSplit[i]);
        }
        region = maskSplit[0];
        newMask = newMask.replaceAll("Х", "#");
        editText.setHint(maskSplit[0].concat(newMask));
        phoneMaskManager = new PhoneMaskManager()
                .withMask(newMask)
                .withRegion(region)
                .bindTo(editText);

    }

    public String getPhone() {
        return phoneMaskManager.getPhone();
    }

    public String getRegion() {
        return region;
    }
}
