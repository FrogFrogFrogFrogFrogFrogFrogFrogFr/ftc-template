package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Null Auto")
public class Auto extends LinearOpMode {

    public double ticksPerInch = 0;
    public double ticksPerDegree = 0;
    public Hardware robot;

    //When you press init
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Hardware(hardwareMap);
        robot.init();

        //waits for u to press start button
        waitForStart();

        //auto actual code
        moveForward(.6, 500);
        moveBackward(.6, 500);
        turnLeft(.6, 500);
        moveForward(.6, 500);
        moveBackward(.6, 500);
        turnRight(.6, 500);
        armUp(200);
        robot.closeClaw();
        robot.openClaw();
        armDown(200);
        robot.openClaw();
        robot.openClaw();
    }

    //auto methods
    public void turnLeft(double power, long time) {
        robot.left.setPower(-power);
        robot.right.setPower(power);
        sleep(time);
        robot.left.setPower(0);
        robot.right.setPower(0);
    }

    public void turnRight(double power, long time) {
        robot.left.setPower(power);
        robot.right.setPower(-power);
        sleep(time);
        robot.left.setPower(0);
        robot.right.setPower(0);
    }

    public void moveForward(double power, long time) {
        robot.left.setPower(power);
        robot.right.setPower(power);
        sleep(time);
        robot.left.setPower(0);
        robot.right.setPower(0);
    }
    public void moveBackward(double power, long time) {
        robot.left.setPower(-power);
        robot.right.setPower(-power);
        sleep(time);
        robot.left.setPower(0);
        robot.right.setPower(0);
    }

    public void armUp(long time) {
        robot.arm.setPower(-.3);
        sleep(time);
        robot.arm.setPower(.3);
    }
    public void armDown(long time) {
        robot.arm.setPower(.3);
        sleep(time);
        robot.arm.setPower(.3);
    }

    public void forwardEncoder(double power, double inches) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches * ticksPerInch);

        robot.left.setTargetPosition(ticks);
        robot.right.setTargetPosition(ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.left.setPower(power);
    }

    public void turnLeftEncoder(double power, double inches) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches * ticksPerDegree);

        robot.left.setTargetPosition(ticks);
        robot.right.setTargetPosition(-ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.left.setPower(power);
    }

    public void turnRightEncoder(double power, double inches) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches * ticksPerDegree);

        robot.left.setTargetPosition(-ticks);
        robot.right.setTargetPosition(ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.left.setPower(power);
    }

    public void backwardEncoder(double power, double inches) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches * ticksPerInch);

        robot.left.setTargetPosition(ticks);
        robot.right.setTargetPosition(ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(-power);
        robot.left.setPower(-power);
    }

}