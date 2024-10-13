<script>
	import { quintOut } from 'svelte/easing';
	import { crossfade } from 'svelte/transition';
	import { flip } from 'svelte/animate';

    let information = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque blandit urna ac augue vehicula, in malesuada mauris scelerisque. Vivamus auctor, nunc in posuere cursus, eros augue aliquam massa, ac bibendum nisl sapien ut metus. Donec feugiat tincidunt nulla at malesuada. Sed tristique, felis vel ullamcorper vehicula, urna orci gravida ipsum, vel varius elit ligula id risus. Nam suscipit semper ex, nec ultricies felis fermentum ut. Cras viverra turpis felis, ut scelerisque est rhoncus a Nulla facilisi. Fusce ac sapien et nunc congue hendrerit. Praesent condimentum justo sit amet arcu interdum fringilla. Integer sit amet ligula fringilla, tincidunt sem sit amet, tempor felis. Maecenas dictum sapien nec metus luctus pharetra. Curabitur sed risus non libero scelerisque interdum eget ut leo. Sed suscipit, metus sit amet egestas rhoncus, nisl orci fermentum velit, at volutpat";
	const [send, receive] = crossfade({
		fallback(node, params) {
			const style = getComputedStyle(node);
			const transform = style.transform === 'none' ? '' : style.transform;

			return {
				duration: 600,
				easing: quintOut,
				css: (t) => `
					transform: ${transform} scale(${t});
					opacity: ${t}
				`
			};
		}
	});

	let todos = [
		{ id: 1, selected: false, name: 'CMPSC 131', description: "shit"},
		{ id: 2, selected: false, name: 'MATH 140', description: "shit 2" },
		{ id: 3, selected: true, name: 'PHY 211', description: "shit 3" },
		{ id: 4, selected: false, name: 'CMLIT 133N', description: "shit 4" },
		{ id: 5, selected: false, name: 'CMPSC 132', description: "shit 5" },
		{ id: 6, selected: false, name: 'ALLAHU AKBAr', description: "Terrorism" }
	];

	


	/**
   * @param {{ id: number; selected: boolean; name: string; description: string; }} todo
   */
	function remove(todo) {
		todos = todos.filter((t) => t !== todo);
        
	}

    $: selectedTodos = todos.filter(todo => todo.selected);
</script>



	<div class="left">
		<h2>Courses</h2>
		{#each todos.filter((t) => !t.selected) as todo (todo.id)}
			<label in:receive={{ key: todo.id }} out:send={{ key: todo.id }} animate:flip>
				<input type="checkbox" bind:checked={todo.selected} />
				{todo.name}
				<button on:click={() => remove(todo)}>x</button>
			</label>
		{/each}
	</div>

	<div class="right">
		<h2>Selected</h2>
		{#each todos.filter((t) => t.selected) as todo (todo.id)}
			<label in:receive={{ key: todo.id }} out:send={{ key: todo.id }} animate:flip>
				<input type="checkbox" bind:checked={todo.selected} />
				{todo.name}
				<button on:click={() => remove(todo)}>x</button>
			</label>
		{/each}
	</div>
    <div class="container">
        {#if selectedTodos.length >0}
    <div class="selected-info">
        <h2>Selected Courses</h2>
        <ul>
            {#each selectedTodos as todo}
                <li>{todo.name} - {todo.description}</li>
            {/each}
        </ul>
    </div>
    {/if}
</div>

<style>
	.left,
	.right {
		float: left;
		width: 50%;
		padding: 0 1em 0 0;
		box-sizing: border-box;
	}

	h2 {
		font-size: 2em;
		font-weight: 200;
		user-select: none;
	}

	label {
		top: 0;
		left: 0;
		display: block;
		font-size: 1em;
		line-height: 1;
		padding: 0.5em;
		margin: 0 auto 0.5em auto;
		border-radius: 2px;
		background-color: #eee;
		user-select: none;
		color: black;
	}

	input {
		margin: 0;
	}

	.right label {
		background-color: rgb(180, 240, 100);
	}

	button {
		float: right;
		height: 1em;
		box-sizing: border-box;
		padding: 0 0.5em;
		line-height: 1;
		background-color: transparent;
		border: none;
		color: rgb(170, 30, 30);
		opacity: 0;
		transition: opacity 0.2s;
	}

	label:hover button {
		opacity: 1;
	}

    .container {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: flex-end; /* Pushes content to the bottom */
            padding: 20px;
            position: relative;
        }

        /* Optional styling for the selected info section */
        .selected-info {
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            padding: 15px;
            border-radius: 8px;
        }

        .selected-info h2 {
            margin-top: 0;
        }

        .selected-info ul {
            list-style: none;
            padding: 0;
        }

        .selected-info li {
            margin-bottom: 10px;
        }

    
</style>

