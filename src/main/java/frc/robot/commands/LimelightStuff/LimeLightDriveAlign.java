/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LimelightStuff;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Enums;
import frc.robot.Robot;
import frc.robot.Enums.DirectionEnum;
import frc.robot.subsystems.Limelight;

public class LimeLightDriveAlign extends CommandBase {
    Enums.DirectionEnum m_defaultDirection;
    Limelight limelight;

    public LimeLightDriveAlign(Enums.DirectionEnum defaultDirection) {
        m_defaultDirection = defaultDirection;
        // Use requires() here to declare subsystem dependencies align
        // eg. requires(chassis);

        addRequirements(Robot.m_DriveTrain, Robot.m_Limelight);

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
            if (m_defaultDirection == DirectionEnum.STOP) {
                Robot.m_DriveTrain.setAll(0.0);
            }
            if (m_defaultDirection == DirectionEnum.LEFT) {
                Robot.m_DriveTrain.setAll(0.3);
            }
            if (m_defaultDirection == DirectionEnum.RIGHT) {
                Robot.m_DriveTrain.setAll(-0.3);
            }
        } else {
            int driveDirection = limelight.getXOffset() < 0 ? -1 : 1;
            double txAbsValue = Math.abs(limelight.getXOffset());
            double motorValue = 0;
            if (txAbsValue > 10) {
                motorValue = 0.3;
            } else {
                if (txAbsValue > 5) {
                    motorValue = 0.15;
                } else if (txAbsValue <= 5) {
                    if (txAbsValue > 3) {
                        motorValue = 0.15;
                    } else if (txAbsValue <= 1.5 && txAbsValue > 0.3) {
                        motorValue = 0.07;
                    }
                }
            }
            Robot.m_DriveTrain.setAll(motorValue * driveDirection);
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
    }

}
