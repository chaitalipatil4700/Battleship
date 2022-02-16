/*****
package com.game.battleship.controller;


import com.game.battleship.model.BattleshipInput;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class BattleshipController {

    @PostMapping("/inputFile")
    public UploadFileResponse  postBody(@RequestParam("file") MultipartFile file) {
        Person persistedPerson = personService.save(person);
        return ResponseEntity
                .created(URI
                        .create(String.format("/persons/%s", person.getFirstName())))
                .body(persistedPerson);
    }
}
*/
