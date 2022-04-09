package com.atb.design.factorymethod;

import com.atb.design.factorymethod.Operation;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 14:04
 */
public class OperationDiv extends Operation {


    @Override
    public double getResult(double a, double b) {
        return a / b;
    }

}
