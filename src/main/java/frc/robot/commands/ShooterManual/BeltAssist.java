/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ShooterManual;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class BeltAssist extends CommandBase {
  double motorSpeed;
  private DigitalInput photoSensor;
  public BeltAssist(double m_motorSpeed) {
    // Use requires() here to declare subsystem dependencies
    motorSpeed = m_motorSpeed;
    addRequirements(Robot.m_BeltOnly);
    photoSensor = new DigitalInput(4);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    Robot.m_BeltOnly.belt(motorSpeed);
    System.out.println(photoSensor.get());
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    // if(photoSensor.get() == true){
    // Robot.m_BeltOnly.belt(motorSpeed);
    // }else{
    //   Robot.m_BeltOnly.belt(0);
    // }
    SmartDashboard.putBoolean("Sensor Covered?", photoSensor.get());
    System.out.println(photoSensor.get());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.m_BeltOnly.belt(0);
  }

}
