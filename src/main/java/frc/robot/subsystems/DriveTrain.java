
package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {

  private WPI_TalonSRX leftLeader = new WPI_TalonSRX(RobotMap.LEFT_BACK_PORT);
  private WPI_TalonSRX leftFollower = new WPI_TalonSRX(RobotMap.LEFT_FRONT_PORT);
  private WPI_TalonSRX rightLeader = new WPI_TalonSRX(RobotMap.RIGHT_BACK_PORT);
  private WPI_TalonSRX rightFollower = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_PORT);

  private final double sensorToInchesConstant = 0.00095;
  private final ADIS16448_IMU gyro = new ADIS16448_IMU();
  
  private DifferentialDrive differentialDrive;

  public DriveTrain() {
    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);
    resetEncoders();
    differentialDrive = new DifferentialDrive(leftLeader, rightLeader);
  }

  public void resetEncoders() {
    leftLeader.setSelectedSensorPosition(0.0);
    rightLeader.setSelectedSensorPosition(0.0);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public double getAverageEncoderDistance() {
    return ((leftLeader.getSelectedSensorPosition() + -rightLeader.getSelectedSensorPosition()) / 2) * sensorToInchesConstant;
  }

  public double getDifferenceInEncoderDistance() {
    return ((leftLeader.getSelectedSensorPosition() + rightLeader.getSelectedSensorPosition())) * sensorToInchesConstant;
  }

  public double getGyroAngle() {
    return gyro.getAngle();
  }

  public Gyro getGyro() {
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
