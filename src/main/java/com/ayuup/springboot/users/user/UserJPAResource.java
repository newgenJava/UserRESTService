package com.ayuup.springboot.users.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;

//import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import jakarta.validation.Valid;

@RestController
public class UserJPAResource {

	@Autowired
	private UserJPARepository jpaService;
	
	@Autowired
	private PostJPARepository postService;

	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return jpaService.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> userFound = jpaService.findById(id);

		if (userFound.isEmpty()) {
			throw new UserNotFoundException(" No User found for id : " + id);
		}

		EntityModel<User> resource = EntityModel.of(userFound.get());

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		if (jpaService.existsById(user.getId())) {
			throw new UserAlreadyExistException(" User found for id : " + user.getId(), user.getId());
		}
		User addedUser = jpaService.save(user);
		UriComponents uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(addedUser.getId());

		return ResponseEntity.created(uriLocation.toUri()).build();
	}

	@PostMapping(path = "/jpa/users", params = "version=2")
	public ResponseEntity<Object> createUserVersion2(@Valid @RequestBody User user) {
		user.setName(user.getName() + "::Version2");
		User addedUser = jpaService.save(user);
		UriComponents uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(addedUser.getId());

		return ResponseEntity.created(uriLocation.toUri()).build();
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		jpaService.deleteById(id);
	}
	
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
		
		Optional<User> userFound = jpaService.findById(id);

		if (userFound.isEmpty()) {
			throw new UserNotFoundException(" No User found for id : " + id);
		}
		
		post.setUser(userFound.get());
		
		Post savedPost = postService.save(post);
		
		
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPost.getId()).toUri();

		return ResponseEntity.created(uriLocation).build();
	}
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retrievePosts(@PathVariable int id) {
		Optional<User> user = jpaService.findById(id);

		if (user.isEmpty()) {
			throw new UserNotFoundException(" No User found for id : " + id);
		}

		return user.get().getPosts();
	}
}
