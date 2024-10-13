<script lang="ts">
    import { Dropdown, DropdownItem } from 'flowbite-svelte';
  
    let credit = "";
    let required = "";
    let genEds = "";
    let message = "";

    function handleSubmit(event:SubmitEvent){
    event.preventDefault();
    const intCredit = Number(credit);
    const intRequired = Number(required);
    const intGenEds = Number(genEds);
    // this part is not working need to work on this 
    if (intCredit<=0 || intGenEds <= 0 || intRequired <= 0) message = "Fill all of them you dumbfuck  ";

    else window.location.href = "/flashcard";
  }
</script>
  
  <style>
    /* Minimalistic styling */
   
    main {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      height: 100vh;
      font-family: 'Arial', sans-serif;
      background-color: #f7f7f7;
      color: #333;
    }
  
    h1 {
      font-size: 2rem;
      margin-bottom: 1rem;
    }
  
    button {
      padding: 10px 20px;
      margin: 5px;
      font-size: 1rem;
      border: none;
      background-color: #007BFF;
      color: white;
      cursor: pointer;
      border-radius: 5px;
      transition: background-color 0.3s ease;
      text-decoration: none;
    }
  
    button:hover {
      background-color: #0056b3;
    }
  </style>
  
  <main>
    <h1>Welcome</h1>
    <button>Major</button>
    <Dropdown>
    <DropdownItem>Computer Science</DropdownItem>
    <DropdownItem>Computer Engineering</DropdownItem>
    <DropdownItem>Psychology</DropdownItem>
    </Dropdown>

    <form on:submit={handleSubmit}>
        <label>
            CREDITS
            <input bind:value={credit}> 
        </label>
        
        <label>
            REQUIRED
            <input bind:value={required}> 
        </label>
    
        <label>
            GEN EDS
            <input bind:value={genEds}> 
        </label>
        
        <button type = "submit">Submit</button>
    </form>

    <p>{message}</p>
  </main>
  
  