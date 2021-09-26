/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.Enums.DirectionEnum;
import frc.robot.Enums.IntakeDirection;
import frc.robot.commands.CommandGroups.ShootSequence;
import frc.robot.commands.LimelightStuff.LimeLightDriveAlign;
import frc.robot.commands.LimelightStuff.LimeLightShooterAlign;
import frc.robot.commands.ShooterManual.Belt;
import frc.robot.commands.ShooterManual.IntakeBall;
import frc.robot.commands.ShooterManual.IntakeDrop;
//import frc.robot.commands.ShooterManual.IntakeRun;
import frc.robot.commands.ShooterManual.ShooterAim;
import frc.robot.commands.ShooterManual.ShooterShoot;
import frc.robot.utils.PlaystationController;

public class OI {
  // DRIVER CONTROLLER
  PlaystationController driverController = new PlaystationController(RobotMap.DRIVER_CONTROLLER);

  // OPERATOR CONTROLLER
  PlaystationController operatorController = new PlaystationController(RobotMap.OPERATOR_CONTROLLER);

  public OI() {
    // Start Driver controls
    driverController.triangle.whileHeld(new Belt(1));
    driverController.square.whileHeld(new Belt(-1));
    driverController.circle.whileHeld(new IntakeBall());
    driverController.options.whileHeld(new IntakeDrop(IntakeDirection.FORWARD));
    driverController.share.whileHeld(new IntakeDrop(IntakeDirection.REVERSE));
    driverController.x.whileHeld(new ShooterShoot(0.8));

    operatorController.circle.whileHeld(new ShooterAim(0.7));
    operatorController.triangle.whileHeld(new ShooterAim(-0.7));
    operatorController.rightTrigger.whileHeld(new LimeLightDriveAlign(DirectionEnum.STOP));
    operatorController.options.whileHeld(new LimeLightShooterAlign(0, 0));
    operatorController.square.whileHeld(new ShootSequence());
    operatorController.x.whileHeld(new ShooterShoot(0.8));
    operatorController.rightTrigger.whileHeld(new Belt(1));
    operatorController.leftTrigger.whileHeld(new Belt(-1));
    operatorController.dPad.right.whileHeld(new StartEndCommand(() -> {
      Robot.m_DriveTrain.setLeftMotorBack(0.1);
      Robot.m_DriveTrain.setLeftMotorFront(0.1);
      Robot.m_DriveTrain.setRightMotorBack(0.1);
      Robot.m_DriveTrain.setRightMotorFront(0.1);
    }, () -> {
      Robot.m_DriveTrain.setAll(0);
    }, Robot.m_DriveTrain));
    operatorController.dPad.left.whileHeld(new StartEndCommand(() -> {
      Robot.m_DriveTrain.setLeftMotorBack(-0.1);
      Robot.m_DriveTrain.setLeftMotorFront(-0.1);
      Robot.m_DriveTrain.setRightMotorBack(-0.1);
      Robot.m_DriveTrain.setRightMotorFront(-0.1);
    }, () -> {
      Robot.m_DriveTrain.setAll(0);
    }, Robot.m_DriveTrain));
    operatorController.dPad.up.whileHeld(new ShooterAim(-0.5));
    operatorController.dPad.down.whileHeld(new ShooterAim(0.5));

    // End Nicks operator controls
  }

  public double GetDriverRawStickAxis(int stickAxis) {
    return driverController.getRawAxis(stickAxis);
  }

  public double GetDriverRawTriggerAxis(int triggerAxis) {
    if (driverController.getRawAxis(triggerAxis) < 0) {
      return 0;
    } else {
      return driverController.getRawAxis(triggerAxis);
    }
  }

  public double GetOperatorRawStickAxis(int stickAxis) {
    return operatorController.getRawAxis(stickAxis);
  }

}
// Sd changes needed in OI, ShootSequence, and Auto
