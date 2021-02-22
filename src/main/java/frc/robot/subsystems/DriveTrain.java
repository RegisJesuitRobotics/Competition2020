
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

public class DriveTrain extends SubsystemBase {

  private WPI_TalonSRX leftLeader = new WPI_TalonSRX(RobotMap.LEFT_BACK_PORT);
  private WPI_TalonSRX leftFollower = new WPI_TalonSRX(RobotMap.LEFT_FRONT_PORT);
  private WPI_TalonSRX rightLeader = new WPI_TalonSRX(RobotMap.RIGHT_BACK_PORT);
  private WPI_TalonSRX rightFollower = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_PORT);

  // private Encoder leftEncoder = new Encoder(0, 0);
  // private Encoder rightEncoder = new Encoder(0, 0);
  

  private DifferentialDrive differentialDrive = new DifferentialDrive(leftLeader, rightLeader);

  public DriveTrain() {
    setDefaultCommand(new Drive());
    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);
  }

  public void resetEncoders() {
    // leftEncoder.reset();
    // rightEncoder.reset();
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public double getAverageEncoderDistance() {
    // return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
    return 0;
  }

  public Encoder getLeftEncoder() {
    // return leftEncoder;
    return null;
  }

  public Encoder getRightEncoder() {
    // return rightEncoder;  
    return null;
  }

  public void setAllSafely() {
    leftLeader.setSafetyEnabled(false);
    leftFollower.setSafetyEnabled(false);

    rightLeader.setSafetyEnabled(false);
    rightFollower.setSafetyEnabled(false);
  }

  public void setAll(double allSpeed) {
    setLeft(allSpeed);
    setRight(allSpeed);
  }

  public void setLeft(double leftSpeed) {
    leftLeader.set(ControlMode.PercentOutput, leftSpeed);
  }

  public void setRight(double rightSpeed) {
    rightLeader.set(ControlMode.PercentOutput, rightSpeed);
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    differentialDrive.arcadeDrive(xSpeed, zRotation);
  }

}
