
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;


public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

    private CANSparkMax leftBack, leftFront, rightBack, rightFront;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Drive());
    leftBack = new CANSparkMax(2, MotorType.kBrushless);
    leftFront = new CANSparkMax(15, MotorType.kBrushless);
    rightBack = new CANSparkMax(1, MotorType.kBrushless);
    rightFront = new CANSparkMax(14, MotorType.kBrushless);

  }
  public void setLeftMotorBack(double leftSpeedBack){
leftBack.set(leftSpeedBack);
  }
  public void setRightMotorBack(double rightSpeedBack){
rightBack.set(rightSpeedBack);
  }
  public void setRightMotorFront(double rightSpeedFront){
    rightFront.set(rightSpeedFront);
      }
      public void setLeftMotorFront(double leftSpeedFront){
        leftFront.set(leftSpeedFront);
          }
}
