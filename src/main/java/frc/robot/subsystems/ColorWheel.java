/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class ColorWheel extends Subsystem {
  
  private CANSparkMax colorWheelMotor;
  private DoubleSolenoid spinnerSolenoid;
  @Override

  public void initDefaultCommand() {
    spinnerSolenoid = new DoubleSolenoid(3, 4);
    colorWheelMotor = new CANSparkMax(RobotMap.COLOR_WHEEL_MOTOR_PORT, MotorType.kBrushless);
  }

  public void spinMotor(double spinSpeed) {
    
    colorWheelMotor.set(spinSpeed);
  }
  public void liftSpinner(int direction){
    if (direction == -1) {
    //  System.out.println("down");
      spinnerSolenoid.set(kReverse);
    } else if (direction == 1) {
    //  System.out.println("up");
      spinnerSolenoid.set(kForward);
    } else if (direction == 0) {
      spinnerSolenoid.set(kOff);

    }
  }
}
