package com.puke.pets;

import com.puke.pets.base.DebugActivity;
import com.puke.pets.login.LoginActivity;
import com.puke.pets.petlist.PetListActivity;

@DebugActivity.Jump({

})
public class SetupActivity extends DebugActivity {

    void _登录() {
        to(LoginActivity.class);
    }

    void _注册() {

    }

    void _个人信息() {

    }

    void _宠物列表() {
        to(PetListActivity.class);
    }

}
