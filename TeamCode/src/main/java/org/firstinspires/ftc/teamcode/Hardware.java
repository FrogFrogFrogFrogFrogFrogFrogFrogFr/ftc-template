package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    //192.168.43.1
    public DcMotor left;
    public DcMotor right;
    public Servo claw;

    public double clawClose = 0.3;
    public double clawOpen = 0.6;
    public boolean clawIsOpen = false;

    public Hardware(HardwareMap hwMap) {
        //Drive motors
        left = hwMap.get(DcMotor.class, "lm");
        right = hwMap.get(DcMotor.class, "rm");


        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Servos
        claw = hwMap.get(Servo.class, "claw");
    }

    public void init() {
        openClaw();
    }
    public void openClaw() {
        claw.setPosition(clawOpen);
        clawIsOpen = true;

    }
    public void closeClaw() {
        claw.setPosition(clawClose);
        clawIsOpen = false;
    }
}
