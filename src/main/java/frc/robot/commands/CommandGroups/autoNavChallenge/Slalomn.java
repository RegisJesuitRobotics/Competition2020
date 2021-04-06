/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups.autoNavChallenge;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoMoveAngleCorrect;
import frc.robot.commands.AutoMoveDistance;
import frc.robot.commands.AutoMoveRotate;
import frc.robot.commands.WaitAndDoNothing;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Slalomn extends SequentialCommandGroup {
  private static double distanceSpeed = 0.7;
  private static double rotateSpeed = 0.7;
  private static double delayTime = 0.3;

  /**
   * Creates a new Slalomn.
   */
  public Slalomn() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      //1
        new AutoMoveDistance(43, distanceSpeed), 
        new WaitAndDoNothing(delayTime), 
        new AutoMoveRotate(-90, rotateSpeed),
        new WaitAndDoNothing(delayTime),
        //2
        new AutoMoveDistance(60, distanceSpeed), 
        new WaitAndDoNothing(delayTime), 
        new AutoMoveRotate(90, rotateSpeed),
        new WaitAndDoNothing(delayTime),
        new AutoMoveAngleCorrect(0, 0.3),
        new WaitAndDoNothing(delayTime),
        //3
        new AutoMoveDistance(188, distanceSpeed),
        new WaitAndDoNothing(delayTime), 
        new AutoMoveRotate(90, rotateSpeed),
        new WaitAndDoNothing(delayTime),
        //4
        new AutoMoveDistance(60, distanceSpeed),
        new WaitAndDoNothing(delayTime), 
        new AutoMoveRotate(-90, rotateSpeed),
        new WaitAndDoNothing(delayTime),
        //5
        new AutoMoveDistance(60, distanceSpeed), 
        new WaitAndDoNothing(delayTime), 
        new AutoMoveRotate(-90, rotateSpeed),
        new WaitAndDoNothing(delayTime),
        //6
        new AutoMoveDistance(55, distanceSpeed), 
        new WaitAndDoNothing(delayTime), 
        new AutoMoveRotate(-90, rotateSpeed),
        new WaitAndDoNothing(delayTime),
        //7
        new AutoMoveDistance(70, distanceSpeed), 
        new WaitAndDoNothing(delayTime),
        new AutoMoveRotate(-90, rotateSpeed),
        new WaitAndDoNothing(delayTime),
        //8
        new AutoMoveDistance(60, distanceSpeed), 
        new WaitAndDoNothing(delayTime), 
        new AutoMoveRotate(90, rotateSpeed),
        new WaitAndDoNothing(delayTime),
        new AutoMoveAngleCorrect(180, 0.3),
        new WaitAndDoNothing(delayTime),
        //9
        new AutoMoveDistance(190, distanceSpeed), 
        new WaitAndDoNothing(delayTime), 
        new AutoMoveRotate(90, rotateSpeed),
        new WaitAndDoNothing(delayTime),
        //10
        new AutoMoveDistance(65, distanceSpeed),
        new WaitAndDoNothing(delayTime), 
        new AutoMoveRotate(-90, rotateSpeed),
        new WaitAndDoNothing(delayTime),
        //11
        new AutoMoveDistance(55, distanceSpeed));
  }
}
