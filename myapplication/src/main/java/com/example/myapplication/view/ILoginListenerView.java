package com.example.myapplication.view;

import com.example.myapplication.retrofix.model.Logins;

public interface ILoginListenerView {
    void getDataSuccess(Logins logins);
    void getMessageError(String e);
}
