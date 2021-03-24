
package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {

  private WPI_TalonSRX leftLeader = new WPI_TalonSRX(RobotMap.LEFT_BACK_PORT);
  private WPI_TalonSRX leftFollower = new WPI_TalonSRX(RobotMap.LEFT_FRONT_PORT);
  private WPI_TalonSRX rightLeader = new WPI_TalonSRX(RobotMap.RIGHT_BACK_PORT);
  private WPI_TalonSRX rightFollower = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_PORT);

  private final double sensorToInchesConstant = 0.00095;
  private final ADXRS450_Gyro gyro;

  
  private DifferentialDrive differentialDrive;

  private double resetValueLeft = 0.0;
  private double resetValueRight = 0.0;

  public DriveTrain() {
    gyro = new ADXRS450_Gyro();
    gyro.calibrate();
    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);
    resetEncoders();
    differentialDrive = new DifferentialDrive(leftLeader, rightLeader);
  }

  public void resetEncoders() {
    resetValueLeft = leftLeader.getSelectedSensorPosition();
    resetValueRight = rightLeader.getSelectedSensorPosition();
    SmartDashboard.putNumber("Reset encoder value left", getLeftEncoder());
    SmartDashboard.putNumber("Reset encdoer value right", getRightEncoder());
  }

  public void calibrateAndResetGyro() {
    gyro.calibrate();
    gyro.reset();
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public double getAverageEncoderDistance() {
    return ((getLeftEncoder() + -getRightEncoder()) / 2) * sensorToInchesConstant;
  }

  public double getDifferenceInEncoderDistance() {
    return ((getLeftEncoder() + getRightEncoder())) * sensorToInchesConstant;
  }

  private double getLeftEncoder() {
    return leftLeader.getSelectedSensorPosition() - resetValueLeft;
  }

  private double getRightEncoder() {
    return rightLeader.getSelectedSensorPosition() - resetValueRight;
  }

  public double getGyroAngle() {
    return gyro.getRotation2d().getDegrees() * -1;
  }

  public ADXRS450_Gyro getGyro() {
    return gyro;
  }

  public void resetGyro() {
    gyro.reset();
  }

  public void setAll(double allSpeed) {
    differentialDrive.tankDrive(allSpeed, allSpeed);
    System.out.println(leftLeader.getSelectedSensorPosition());
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    differentialDrive.arcadeDrive(xSpeed, zRotation);
  }

}
