/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Drive;
import frc.robot.commands.CommandGroups.Auto;
import frc.robot.subsystems.Belt;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeBar;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.ShootWheels;
import frc.robot.subsystems.UpAndDown;

public class Robot extends TimedRobot {

  public static OI m_oi;
  public static DriveTrain m_DriveTrain = new DriveTrain();
  public static ShootWheels m_Shooter = new ShootWheels();
  public static Belt m_Belt = new Belt();
  public static UpAndDown m_UpAndDown = new UpAndDown();
  public static IntakeBar m_IntakeBar = new IntakeBar();
  public static Limelight m_Limelight = new Limelight();
  // public static ColorWheel m_ColorWheel = new ColorWheel();
  // read values periodically
  CommandBase m_autonomousCommand;
  PowerDistributionPanel PDP;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    m_autonomousCommand = new Auto();
    // m_autonomousCommand = new WaitCommand(20);
    m_oi = new OI();

    PDP = new PowerDistributionPanel();

    SmartDashboard.putData("Auto mode", m_chooser);

    m_DriveTrain.setDefaultCommand(new Drive());
  }

  @Override
  public void robotPeriodic() {
    // PDP.clearStickyFaults();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    autoTelePeriodic();
  }

  private void autoTelePeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    m_autonomousCommand.cancel();
  }

  @Override
  public void teleopPeriodic() {
    autoTelePeriodic();
  }

  @Override
  public void testPeriodic() {
  }
}
