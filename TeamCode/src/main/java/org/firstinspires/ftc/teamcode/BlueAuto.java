package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Blue Auto")
public class BlueAuto extends LinearOpMode {

    public double ticksPerInch = 45.29;
    public double ticksPerDegree = 5.67;
    public Hardware robot;

    //When you press init
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Hardware(hardwareMap);
        robot.init();

        //waits for u to press start button
        waitForStart();

        //auto actual code                //ALEX LIKES BOYS
        robot.arm.setPower(0);
        forwardEncoder(0.2,49.5);
        sleep(5000);
        turnRightEncoder(0.2, 45);
        sleep(5000);
        forwardEncoder(0.2, 28);
        sleep(5000);
        backwardEncoder(0.2, 24);
        robot.arm.setPower(0);

        while(opModeIsActive()) {
            telemetry.addData("ticks l", robot.left.getCurrentPosition());
            telemetry.addData("ticks r", robot.right.getCurrentPosition());

            telemetry.addData("target l", robot.left.getCurrentPosition());
            telemetry.addData("target r", robot.right.getCurrentPosition());

            telemetry.update();
        }
        sleep(150000);
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
        robot.right.setPower(power);
    }

    public void turnLeftEncoder(double power, double degrees) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (degrees * ticksPerDegree);

        robot.left.setTargetPosition(ticks);
        robot.right.setTargetPosition(-ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);
    }

    public void turnRightEncoder(double power, double degrees) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (degrees * ticksPerDegree);

        robot.left.setTargetPosition(-ticks);
        robot.right.setTargetPosition(ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);
    }

    public void backwardEncoder(double power, double inches) {
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches * ticksPerInch);

        robot.left.setTargetPosition(-ticks);
        robot.right.setTargetPosition(-ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);
    }

}