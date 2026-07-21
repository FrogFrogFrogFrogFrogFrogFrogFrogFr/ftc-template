package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    //192.168.43.1
    public DcMotor left;
    public DcMotor right;
    public Servo claw;
    public DcMotor arm;

    public double clawClose = 0.4;
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

        left.setDirection(DcMotorSimple.Direction.REVERSE);

        //Servos
        claw = hwMap.get(Servo.class, "claw");

        arm = hwMap.get(DcMotor.class, "arm");

        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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
