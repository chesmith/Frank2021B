// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private final WPI_TalonSRX _frontLeftMotor = new WPI_TalonSRX(0);
  private final WPI_TalonSRX _frontRightMotor = new WPI_TalonSRX(1);
  private final WPI_TalonSRX _rearLeftMotor = new WPI_TalonSRX(2);
  private final WPI_TalonSRX _rearRightMotor = new WPI_TalonSRX(3);

  private final MecanumDrive _drive = new MecanumDrive(_frontLeftMotor, _rearLeftMotor, _frontRightMotor, _rearRightMotor);

  /** Creates a new Drivetrain. */
  public Drivetrain() { }

  public void teleopDrive(Joystick joystick) {
    double ySpeed = joystick.getRawAxis(Constants.JoystickConstants.LEFT_STICK_X);
    double xSpeed = joystick.getRawAxis(Constants.JoystickConstants.LEFT_STICK_Y);
    double zRotation = joystick.getRawAxis(Constants.JoystickConstants.RIGHT_STICK_X);

    _drive.driveCartesian(ySpeed, -xSpeed, zRotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
