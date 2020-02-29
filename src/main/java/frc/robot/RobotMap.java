/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static final int DRIVER_CONTROLLER = 0;
  public static final int OPERATOR_CONTROLLER = 1;
  // drive controller constants
  public static final int LEFT_STICK_X = 0;
  public static final int LEFT_TRIGGER_PORT = 3;
  public static final int RIGHT_TRIGGER_PORT = 4;

  // drive constants
  public static final double DEADZONE = 0.1;
  public static final double LIMITER = 0.8;

  // shooter ports
  public static final int INTAKE_PORT = 5;
  public static final int BELT_PORT = 11;
  public static final int SHOOTER_WHEELS_PORT_LEFT = 13;
  public static final int SHOOTER_WHEELS_PORT_RIGHT = 2;
  public static final int ADJUST_PORT = 12;

  // color wheel ports
  public static final int COLOR_WHEEL_MOTOR_PORT = 0;

  // drive train ports
  public static final int LEFT_BACK_PORT = 15;
  public static final int LEFT_FRONT_PORT = 14;
  public static final int RIGHT_BACK_PORT = 1;
  public static final int RIGHT_FRONT_PORT = 0;
  public static final int INTAKE_DROP_PORT = 42069;
  public static final int INTAKE_BAR_PORT = 5;

}
