package com.annie.annieforchild.ui.login.activity;

import android.os.Bundle;
import android.view.View;

import com.annie.annieforchild.BR;
import com.annie.annieforchild.R;
import com.annie.annieforchild.databinding.ActivityAddStudentBinding;
import com.annie.annieforchild.ui.login.vm.AddStudentViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class AddStudentActivity extends BaseActivity<ActivityAddStudentBinding, AddStudentViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_add_student;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        binding.goBack.setVisibility(View.VISIBLE);
        binding.titleBar.setText("添加学员");
    }
}
