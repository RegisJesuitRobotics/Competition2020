/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LimelightStuff;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Limelight;

public class LimeLightShooterAlign extends CommandBase {
  Limelight limelight;
  int m_defaultDirection;
  double m_max;

  public LimeLightShooterAlign(int defaultDirection, double max) {
    addRequirements(Robot.m_Shooter, Robot.m_Limelight);

    m_defaultDirection = defaultDirection;
    m_max = max;
    // Use requires() here to declare subsystem dependencies align
    // eg. requires(chassis);
    this.limelight = Robot.m_Limelight;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    if (!limelight.hasValidTarget()) {
      if (m_defaultDirection == 0) {
        Robot.m_UpAndDown.aim(0);
      }
      if (m_defaultDirection == 1) {
        Robot.m_UpAndDown.aim(-0.2);
      }
      if (m_defaultDirection == -1) {
        Robot.m_UpAndDown.aim(0.2);
      }
    } else {
      if (limelight.getYOffset() > -10.5 - m_max) {
        // go up
        SmartDashboard.putString("Shooter Align Status", "UP");
        Robot.m_UpAndDown.aim(-0.2);
      } else if (limelight.getYOffset() < -12.5 - m_max) {
        // go down
        SmartDashboard.putString("Shooter Align Status", "DOWN");
        Robot.m_UpAndDown.aim(0.15);
      } else {
        SmartDashboard.putString("Shooter Align Status", "STOPPED");
        Robot.m_UpAndDown.aim(0);
      }
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
