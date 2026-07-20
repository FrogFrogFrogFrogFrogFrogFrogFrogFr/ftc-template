package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Null Auto")
public class Auto extends LinearOpMode {

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

}