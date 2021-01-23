/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LimelightStuff;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class LimeLightShooterAlign extends CommandBase {
  int m_defaultDirection;
  double m_max;
  public LimeLightShooterAlign(int defaultDirection, double max) {
    m_defaultDirection = defaultDirection;
    m_max = max;
    // Use requires() here to declare subsystem dependencies align
    // eg. requires(chassis);

    addRequirements(Robot.m_Shooter);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    NetworkTableInstance instance = NetworkTableInstance.getDefault();
    NetworkTable table = instance.getTable("limelight-limeboi");
    // NetworkTable fms = instance.getTable("FMSInfo");
    // NetworkTableEntry g = fms.getEntry("StationNumber");
    // NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry tv = table.getEntry("tv");
    boolean TVboolean = tv.getDouble(0.0) == 1;
    if(!TVboolean){
      if(m_defaultDirection == 0){
        Robot.m_UpAndDown.aim(0);
      }
      if(m_defaultDirection == 1){
        Robot.m_UpAndDown.aim(-0.2);
      }
      if(m_defaultDirection == -1){
        Robot.m_UpAndDown.aim(0.2);
      }
    }
    if (TVboolean) {
      System.out.println("You have a valid target");
      if (ty.getDouble(0.0) > -10.5 - m_max) {
        // go up
        System.out.println("UUUUUUUUUUUP");
        Robot.m_UpAndDown.aim(-0.5);
      } else if (ty.getDouble(0.0) < -11.5 - m_max) {
        // go down
        System.out.println("NOT UUUUUUUUUP");
        Robot.m_UpAndDown.aim(0.22);
      } else {
        System.out.println("stop");
        Robot.m_UpAndDown.aim(0);
      }
    } else {
      System.out.println("You do not hava a valid target");
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.m_UpAndDown.aim(0);
  }

}

// -7.8