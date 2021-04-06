// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.CommandGroups.autoNavChallenge;

import java.util.Map;

import edu.wpi.first.wpilibj2.command.SelectCommand;
import frc.robot.Robot;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class GalacticSearch extends SelectCommand {
  public enum Routes {
    REDA, REDB, BLUEA, BLUEB;
  }

  /** Creates a new GalacticSearch. */
  public GalacticSearch(Robot robot) {
    super(Map.ofEntries(Map.entry(Routes.REDA, new GalacticSearchReleaseAndStart(new GalacticSearchARed())),
        Map.entry(Routes.REDB, new GalacticSearchReleaseAndStart(new GalacticSearchBRed())),
        Map.entry(Routes.BLUEA, new GalacticSearchReleaseAndStart(new GalacticSearchABlue())),
        Map.entry(Routes.BLUEB, new GalacticSearchReleaseAndStart(new GalacticSearchBBlue()))), robot::getRoute);
  }
}
