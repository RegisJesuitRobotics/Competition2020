
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

public class DriveTrain extends Subsystem {
  private TalonSRX leftBack, leftFront, rightBack, rightFront;

  @Override
  public void initDefaultCommand() {

    setDefaultCommand(new Drive());
    leftBack = new TalonSRX(RobotMap.LEFT_BACK_PORT);
    leftFront = new TalonSRX(RobotMap.LEFT_FRONT_PORT);
    rightBack = new TalonSRX(RobotMap.RIGHT_BACK_PORT);
    rightFront = new TalonSRX(RobotMap.RIGHT_FRONT_PORT);

  }

  public void setAll(double allSpeed) {
    setLeftMotorBack(allSpeed);
    setLeftMotorFront(allSpeed);
    setRightMotorBack(allSpeed);
    setRightMotorFront(allSpeed);
  }

  public void setLeftMotorBack(double leftBackSpeed) {
    leftBack.set(ControlMode.PercentOutput, leftBackSpeed);
  }

  public void setRightMotorBack(double rightBackSpeed) {
    rightBack.set(ControlMode.PercentOutput, rightBackSpeed);
  }

  public void setRightMotorFront(double rightFrontSpeed) {
    rightFront.set(ControlMode.PercentOutput, rightFrontSpeed);
  }

  public void setLeftMotorFront(double leftFrontSpeed) {
    leftFront.set(ControlMode.PercentOutput, leftFrontSpeed);
  }

}
