// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.CommandGroups.autoNavChallenge;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoMoveDistance;
import frc.robot.commands.AutoMoveRotate;
import frc.robot.commands.WaitAndDoNothing;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class GalacticSearchARed extends SequentialCommandGroup {
  private final double distanceSpeed = 0.7;
  private final double rotationSpeed = 0.7;
  private final double waitTime = 0.3;

  /** Creates a new GalacticSearchARed. */
  public GalacticSearchARed() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoMoveDistance(150, 0.7), new WaitAndDoNothing(waitTime), new AutoMoveRotate(-100, rotationSpeed),
        new WaitAndDoNothing(waitTime), new AutoMoveDistance(100, distanceSpeed), new WaitAndDoNothing(waitTime),
        new AutoMoveRotate(90, rotationSpeed), new WaitAndDoNothing(0.4), new AutoMoveDistance(200, distanceSpeed));
  }
}
