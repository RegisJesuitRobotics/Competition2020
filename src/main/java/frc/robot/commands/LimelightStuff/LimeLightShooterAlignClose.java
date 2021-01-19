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
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LimeLightShooterAlignClose extends Command {
  public LimeLightShooterAlignClose() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    NetworkTableInstance instance = NetworkTableInstance.getDefault();
    NetworkTable table = instance.getTable("limelight-limeboi");
    // NetworkTable fms = instance.getTable("FMSInfo");
    // NetworkTableEntry g = fms.getEntry("StationNumber");
    // NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry tv = table.getEntry("tv");
    boolean TVboolean = tv.getDouble(0.0) == 1;

    if (TVboolean) {
      System.out.println("You have a valid target");
      if (ty.getDouble(0.0) > -8.5) {
        // go up
        System.out.println("UUUUUUUUUUUP");
        Robot.m_UpAndDown.aim(0.7);
      } else if (ty.getDouble(0.0) < -9.5) {
        // go down
        System.out.println("NOT UUUUUUUUUP");
        Robot.m_UpAndDown.aim(-0.7);
      } else {
        System.out.println("stop");
        Robot.m_UpAndDown.aim(0);
      }
    } else {
      System.out.println("You do not hava a valid target");
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.m_UpAndDown.aim(0);
  }

  @Override
  protected void interrupted() {
    this.end();
  }
}
