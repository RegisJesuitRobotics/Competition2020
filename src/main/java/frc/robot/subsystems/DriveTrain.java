
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
    
  private TalonSRX leftBack = new TalonSRX(RobotMap.LEFT_BACK_PORT);
  private TalonSRX leftFront = new TalonSRX(RobotMap.LEFT_FRONT_PORT);
  private TalonSRX rightBack = new TalonSRX(RobotMap.RIGHT_BACK_PORT);
  private TalonSRX rightFront = new TalonSRX(RobotMap.RIGHT_FRONT_PORT);


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
