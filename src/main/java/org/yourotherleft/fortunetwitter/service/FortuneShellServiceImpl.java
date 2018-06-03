package org.yourotherleft.fortunetwitter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.yourotherleft.fortunetwitter.service.type.Fortune;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("fortuneShell")
public class FortuneShellServiceImpl implements FortuneService {

    private final static Logger logger = LoggerFactory.getLogger(FortuneShellServiceImpl.class);

    @Override
    public Fortune getFortune() {
        // prepare to execute "fortune" from the home directory
        final File homeDir = new File(System.getProperty("user.home"));
        final ProcessBuilder processBuilder = new ProcessBuilder()
                .command("fortune")
                .directory(homeDir);

        // execute and capture its output
        final String fortuneOutput;
        try {
            final Process process = processBuilder.start();
            fortuneOutput = executeAndReadOutput(process);
        } catch (final IOException e) {
            throw new IllegalStateException("unable to execute fortune from command line, is it on your PATH?", e);
        }

        // build and return a fortune
        final Fortune fortune = Fortune.builder()
                .text(fortuneOutput)
                .build();

        logger.info("generated new fortune using executable: {}", fortune);

        return fortune;
    }

    private String executeAndReadOutput(final Process process) throws IOException {
        // set up a reader using the process's input stream. it seems like it should be the output stream, but this is correct.
        final BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

        // read the output, line by line
        final List<String> lines = new ArrayList<>();
        String line;
        while((line = stdInput.readLine()) != null) {
            lines.add(line);
        }

        return lines.stream().collect(Collectors.joining("\n"));
    }

}
