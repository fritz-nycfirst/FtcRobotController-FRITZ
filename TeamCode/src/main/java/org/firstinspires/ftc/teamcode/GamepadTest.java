package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp
public class GamepadTest extends LinearOpMode {
    @Override
    public void runOpMode() {

        Gamepad currentGamepad1 = new Gamepad();
        Gamepad currentGamepad2 = new Gamepad();

        Gamepad previousGamepad1 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();

        DcMotor frontLeftDrive = hardwareMap.dcMotor.get("frontLeftDrive");
        DcMotor backLeftDrive = hardwareMap.dcMotor.get("backLeftDrive");
        DcMotor frontRightDrive = hardwareMap.dcMotor.get("frontRightDrive");
        DcMotor backRightDrive = hardwareMap.dcMotor.get("backRightDrive");
        DcMotor intakeMotor = hardwareMap.dcMotor.get("intakeMotor");

        frontLeftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        boolean intakeToggle = false;


        while (opModeIsActive()) {
            previousGamepad1.copy(currentGamepad1);
            previousGamepad2.copy(currentGamepad2);

            currentGamepad1.copy(gamepad1);
            currentGamepad2.copy(gamepad2);


        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            // Rising edge detector

            if (currentGamepad1.a && !previousGamepad1.a) {
                // This will set intakeToggle to true if it was previously false
                // and intakeToggle to false if it was previously true,
                // providing a toggling behavior.
                intakeToggle = !intakeToggle;
            }

            // Using the toggle variable to control the robot.
            if (intakeToggle) {
                intakeMotor.setPower(1);
            }
            else {
                intakeMotor.setPower(0);
            }

            //Falling Edge Detector
            /*
            if (!currentGamepad1.b && previousGamepad1.b) {
            servo.setPosition(servo.getPosition() - 0.1);
            }
            */

            //Rumble
            //Rumble, Motor 1, 100% for set time in Ms
            //gamepad1.rumble(int durationMs);

            /*Rumble, Both motors intensity control
            gamepad1.rumble(1.0, 1.0, 500);
            gamepad1.rumbleBlips(10);

            Gamepad.RumbleEffect effect = new Gamepad.RumbleEffect.Builder()
                    .addStep(0.0, 1.0, 500)
                    .addStep(0.0, 0, 300)
                    .addStep(1.0, 0.0, 250)
                    .addStep(0.0, 0.0, 250)
                    .build();

            gamepad1.runRumbleEffect(effect);*/
            }
        }
    }
}
